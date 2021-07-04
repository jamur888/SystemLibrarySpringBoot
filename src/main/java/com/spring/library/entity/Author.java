package com.spring.library.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private long authorId;

    @Column(name="author_name")
    private String authorName;

    @Column(name="author_description")
    private String authorDescription;

    @ManyToMany
    @JoinTable (name="author_books",
            joinColumns=@JoinColumn (name="author_author_id"),
            inverseJoinColumns=@JoinColumn(name="books_book_id"))
    private List<Book> books;

   /* @OneToMany(targetEntity=Book.class)
    private List<Book> books = new ArrayList<>();
*/
   public Author() {
    }

    public Author(String authorName, String authorDescription) {
        this.authorName = authorName;
        this.authorDescription = authorDescription;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDescription() { return authorDescription; }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(authorName, author.authorName) && Objects.equals(authorDescription, author.authorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, authorDescription);
    }
}
