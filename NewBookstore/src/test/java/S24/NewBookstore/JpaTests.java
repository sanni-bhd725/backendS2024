package S24.NewBookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import S24.NewBookstore.domain.Book;
import S24.NewBookstore.domain.BookRepository;

public class JpaTests {

    @Autowired
    BookRepository bRepository;

    @Test
    public void findByAuthorNameShouldReturnAuthor() {
        List<Book> books = bRepository.findByAuthor("Mirja");
    }
}
