package S24.NewBookstore.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import S24.NewBookstore.domain.*;

@RestController
public class RESTbookController {

    private static final Logger log = LoggerFactory.getLogger(RESTbookController.class);

    @Autowired
    BookRepository bRepository;
    @Autowired
    CategoryRepository cRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        log.info("fetch all books from db and return to client as json");
        return bRepository.findAll();
    }

    @SuppressWarnings("null")
    @GetMapping("/book/{id}")
    public Optional<Book> getOneBook(@PathVariable("id") Long id) {
        log.info("fetch a one book from db and return to client as json " + id);
        return bRepository.findById(id);
    }

    @SuppressWarnings("null")
    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        log.info("save a new book" + newBook);
        return bRepository.save(newBook);
    }

    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        log.info("editBook = " + editedBook);
        log.info("edit book, id = " + id);
        editedBook.setId(id);
        log.info("editBook = " + editedBook);
        return bRepository.save(editedBook);
    }

}