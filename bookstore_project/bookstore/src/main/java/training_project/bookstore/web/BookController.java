package training_project.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import training_project.bookstore.domain.*;

@Controller
public class BookController {

    private final BookRepository bRepository;
    private final CategoryRepository cRepository;

    public BookController(BookRepository bRepository, CategoryRepository cRepository) {
        this.bRepository = bRepository;
        this.cRepository = cRepository;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/booklist")
    public String showBooks(Model model) {
        model.addAttribute("books", bRepository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/savebook")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveBook(@ModelAttribute("book") Book book) {
        bRepository.save(book);
        return "redirect:booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable("id") Long id, Model model) {
        bRepository.deleteById(id);
        return "redirect:../booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("editbook/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bRepository.findById(id));
        model.addAttribute("categories", cRepository.findAll());
        return "editbook";
    }
}
