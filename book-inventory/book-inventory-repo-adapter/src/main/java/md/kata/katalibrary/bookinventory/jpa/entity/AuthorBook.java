package md.kata.katalibrary.bookinventory.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

@Entity
@Table(
    name = "author_book",
    uniqueConstraints = @UniqueConstraint(name = "uk_author_book", columnNames = {"author_id", "book_id"})
)
public class AuthorBook {

  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id", nullable = false)
  private Book book;

  private String role;

  protected AuthorBook() {
  }

  public AuthorBook(Author author, Book book) {
    this.author = author;
    this.book = book;
  }

  public UUID getId() {
    return id;
  }

  public Author getAuthor() {
    return author;
  }

  public Book getBook() {
    return book;
  }
}
