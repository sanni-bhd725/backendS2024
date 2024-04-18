package FinalProject.SleepTracker.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import FinalProject.SleepTracker.domain.*;

@RestController
public class RESTsleepController {

    private static final Logger log = LoggerFactory.getLogger(RESTsleepController.class);

    @Autowired
    SleepRepository sRepository;
    @Autowired
    AppUserRepository auRepository;

    @GetMapping("/sleeps")
    public Iterable<Sleep> getSleeps() {
        log.info("fetch all sleep data from db and return to client as json");
        return sRepository.findAll();
    }

    @GetMapping("/sleep/{id}")
    public Optional<Sleep> getOneSleep(@PathVariable("id") Long id) {
        log.info("fetch a one sleep from db and return to client as json " + id);
        return sRepository.findById(id);
    }

    @PostMapping("/sleep")
    Sleep newSleep(@RequestBody Sleep newSleep) {
        log.info("save a new sleep data" + newSleep);
        return sRepository.save(newSleep);
    }

    @PutMapping("/sleep/{id}")
    Sleep editSleep(@RequestBody Sleep editedSleep, @PathVariable Long id) {
        log.info("editSleep = " + editedSleep);
        log.info("edit sleep, id = " + id);
        editedSleep.setId(id);
        log.info("editSleep = " + editedSleep);
        return sRepository.save(editedSleep);
    }
}
