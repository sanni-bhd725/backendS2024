package training_project.bookstore.domain;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String author, isbn, title;
    public int publicationYear;
    public double price;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    public Book() {
    }

    public Book(String author, String isbn, String title, int publicationYear, double price) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book(String author, String isbn, String title, int publicationYear, double price, Category category) {
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", title=" + title
                    + ", publicationYear=" + publicationYear + ", price=" + price
                    + ", category=" + this.getCategory() + "]";
        else
            return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", title=" + title
                    + ", publicationYear=" + publicationYear + ", price=" + price + "]";
    }

}
