package md.kata.katalibrary.book.models;

import java.util.List;
import java.util.UUID;

public record Book(UUID id, String isbn, String title, List<Author> author) {

  public Book(UUID id, String isbn, String title) {
    this(id, isbn, title, List.of());
  }

  public Book(UUID id) {
    this(id, null, null);
  }
}
