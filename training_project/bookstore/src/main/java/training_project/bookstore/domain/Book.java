package training_project.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String author, isbn, title;
    public int publicationYear;
    public double price;

    public Book() {
        super();
    }

    public Book(String author, String isbn, String title, int publicationYear, double price) {
        super();
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public Book(long id, String author, String isbn, String title, int publicationYear, double price) {
        this.id = id;
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getpublicationYear() {
        return publicationYear;
    }

    public void setpublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", title=" + title + ", publicationYear="
                + publicationYear
                + ", price=" + price + "]";
    }
}
