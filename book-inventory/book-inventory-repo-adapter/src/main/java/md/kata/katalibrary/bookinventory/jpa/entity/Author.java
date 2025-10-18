package md.kata.katalibrary.bookinventory.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(
    name = "author",
    indexes = {
        @Index(name = "idx_author_last_name", columnList = "last_name"),
        @Index(name = "idx_author_first_name", columnList = "first_name"),
        @Index(name = "idx_author_last_first", columnList = "last_name, first_name")
    }
)
public class Author {

  @Id @GeneratedValue
  private UUID id;

  @NotBlank private String firstName;
  @NotBlank private String lastName;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AuthorBook> authorBooks = new ArrayList<>();

  protected Author() {}

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UUID getId() { return id; }

  public String getFirstName() { return firstName; }

  public String getLastName() { return lastName; }

  public List<AuthorBook> getAuthorBooks() { return authorBooks; }
}
