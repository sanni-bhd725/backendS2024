package training_project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import training_project.bookstore.domain.Book;
import training_project.bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("delete/{id}")
    public String deleteCar(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("editbook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "editbook";
    }
}
