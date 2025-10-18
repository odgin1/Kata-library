package md.kata.katalibrary.bookinventory.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "book")
public class Book {

  @Id @GeneratedValue
  private UUID id;

  @Version
  private long version;

  @NotBlank private String title;
  @NotBlank private String isbn;
  @Min(0) private int copiesTotal;
  @Min(0) private int copiesAvailable;

  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AuthorBook> authorBooks = new ArrayList<>();

  protected Book() {}

  public Book(String title, String isbn, int copies) {
    this.title = title;
    this.isbn = isbn;
    copiesTotal = copies;
    copiesAvailable = copies;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  public int getCopiesAvailable() {
    return copiesAvailable;
  }

  public void addNewBookCopy() {
    copiesAvailable++;
    copiesTotal++;
  }

  public void takeOne() {
    if (copiesAvailable == 0) {
      throw new IllegalStateException("No copies available");
    }
    copiesAvailable--;
  }

  public void returnOne() {
    if (copiesAvailable >= copiesTotal) {
      throw new IllegalStateException("All copies already returned");
    }
    copiesAvailable++;
  }

}
