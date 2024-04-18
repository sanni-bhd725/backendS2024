package FinalProject.SleepTracker.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import FinalProject.SleepTracker.domain.*;
import jakarta.validation.Valid;

@Controller
public class SleepController {

    @Autowired
    private final SleepRepository sRepository;
    @Autowired
    private final AppUserRepository auRepository;

    public SleepController(SleepRepository sRepository, AppUserRepository auRepository) {
        this.sRepository = sRepository;
        this.auRepository = auRepository;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/main")
    public String showSleeps(Model model, Authentication authentication) {

        // For user roles showing only their own data
        String username = authentication.getName();
        List<Sleep> userSleeps = sRepository.findByAppUserUsername(username);

        // Sorting sleep objects by date (descending)
        userSleeps.sort(Comparator.comparing(Sleep::getDateInput).reversed());
        model.addAttribute("sleeps", userSleeps);

        // Showing all data for admin
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            Iterable<Sleep> allSleepsIterable = sRepository.findAll();
            List<Sleep> allSleeps = new ArrayList<>();
            allSleepsIterable.forEach(allSleeps::add);

            allSleeps.sort(Comparator.comparing((Sleep sleep) -> sleep.getAppUser().getUsername())
                    .thenComparing(Sleep::getDateInput)
                    .reversed());

            model.addAttribute("allSleeps", allSleeps);
        }

        return "main";
    }

    @GetMapping("/addsleep")
    public String addSleep(Model model, Authentication authentication) {
        model.addAttribute("sleep", new Sleep());

        // Admin role can choose from all usernames
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            model.addAttribute("users", auRepository.findAll());
        }

        return "addsleep";
    }

    @PostMapping("/save")
    public String saveSleep(@Valid @ModelAttribute("sleep") Sleep sleep, BindingResult bindingResult,
            @RequestParam(value = "selectedUsername", required = false) String selectedUsername,
            Authentication authentication, Model model) {

        // Handling a validation errors
        if (bindingResult.hasErrors()) {
            System.out.println("Validation error");

            // Keeping filled in data in the form while showing error message
            model.addAttribute("sleep", sleep);

            if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
                model.addAttribute("users", auRepository.findAll());
            }
            return "/addsleep";
        }

        // Searching the logged in user
        String username = authentication.getName();
        AppUser appUser = auRepository.findByUsername(username);

        // Username selection for admin authorities
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {

            if (selectedUsername != null && !selectedUsername.isEmpty()) {
                appUser = auRepository.findByUsername(selectedUsername);
            }
        }
        sleep.setAppUser(appUser);
        sRepository.save(sleep);

        return "redirect:/main";

    }

    @SuppressWarnings("null")
    @GetMapping("/editsleep/{id}")
    public String editSleep(@PathVariable("id") Long id, Model model, Authentication authentication) {

        // Searching the logged in user
        String username = authentication.getName();
        AppUser appUser = auRepository.findByUsername(username);

        // Searching data by sleep id
        Optional<Sleep> optionalSleep = sRepository.findById(id);
        if (optionalSleep.isPresent()) {
            Sleep sleep = optionalSleep.get();

            // Calling to rights checking method
            if (!canEditSleep(sleep, appUser, authentication)) {
                // With no rights turning back to the main page
                return "redirect:/main";
            }

            model.addAttribute("sleep", sleep);
            // All usernames for ADMINs' select-element
            model.addAttribute("users", auRepository.findAll());
            // Selecting username
            model.addAttribute("selectedUsername", sleep.getAppUser().getUsername());
            return "editsleep";

        } else {
            return "redirect:/main";
        }
    }

    // Method to checking rights to edit data
    private boolean canEditSleep(Sleep sleep, AppUser appUser, Authentication authentication) {
        // Admin can edit all
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return true;
        }
        // Users can edit their own data
        return sleep.getAppUser().equals(appUser);
    }

    @SuppressWarnings("null")
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        sRepository.deleteById(id);
        return "redirect:../main";
    }

}
