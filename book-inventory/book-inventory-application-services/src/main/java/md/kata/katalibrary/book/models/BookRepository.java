package md.kata.katalibrary.book.models;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
  Optional<Book> findByIsbn(String isbn);

  Optional<Book> findByBookId(UUID bookId);

  void returnBook(UUID bookId);

  void takeBook(UUID bookId);

  void addNewBook(Book book);
}
