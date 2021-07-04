package com.spring.library.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="publisher_id")
    private long publisherId;

    @Column(name="publisher_name")
    private String publisherName;

    @Column(name="publisher_description")
    private String publisherDescription;

    @ManyToMany
    @JoinTable (name="publisher_books",
            joinColumns=@JoinColumn (name="publisher_publisher_id"),
            inverseJoinColumns=@JoinColumn(name="books_book_id"))
    private List<Book> books;

    /* @OneToMany(targetEntity=Book.class)
    private List<Book> books = new ArrayList<>();
*/
    public Publisher() {

    }

    public Publisher(String publisherName, String publisherDescription) {
        this.publisherName = publisherName;
        this.publisherDescription = publisherDescription;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherDescription() {
        return publisherDescription;
    }

    public void setPublisherDescription(String publisherDescription) {
        this.publisherDescription = publisherDescription;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId == publisher.publisherId && Objects.equals(publisherName, publisher.publisherName) && Objects.equals(publisherDescription, publisher.publisherDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, publisherName, publisherDescription);
    }
}
