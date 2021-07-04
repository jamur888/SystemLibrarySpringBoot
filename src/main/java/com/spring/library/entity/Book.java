package com.spring.library.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long bookId;

    private String isbn;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_sub_name")
    private String bookSubName;

    @Column(name = "book_serial_name")
    private String bookSerialName;

    @Column(name = "book_description")
    private String bookDescription;

    /*  @ManyToOne
      @JoinColumn(name = "author_id", nullable = false)
      private Author author;

      @ManyToOne
      @JoinColumn(name = "publisher_id", nullable = false)
      private Publisher publisher;
  */
    @ManyToMany
    @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "books_book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_author_id"))
    private List<Author> author;

    @ManyToMany
    @JoinTable(name = "publisher_books",
            joinColumns = @JoinColumn(name = "books_book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_publisher_id"))
    private List<Publisher> publisher;

    public Book() {

    }

    public Book(String isbn, String bookName, String bookSubName, String bookSerialName,
                String bookDescription, List<Author> author, List<Publisher> publisher) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookSubName = bookSubName;
        this.bookSerialName = bookSerialName;
        this.bookDescription = bookDescription;
        this.author = author;
        this.publisher = publisher;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSubName() {
        return bookSubName;
    }

    public void setBookSubName(String bookSubName) {
        this.bookSubName = bookSubName;
    }

    public String getBookSerialName() {
        return bookSerialName;
    }

    public void setBookSerialName(String bookSerialName) {
        this.bookSerialName = bookSerialName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<Publisher> publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Objects.equals(isbn, book.isbn) && Objects.equals(bookName, book.bookName) && Objects.equals(bookSubName, book.bookSubName) && Objects.equals(bookSerialName, book.bookSerialName) && Objects.equals(bookDescription, book.bookDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, bookName, bookSubName, bookSerialName, bookDescription);
    }
}
