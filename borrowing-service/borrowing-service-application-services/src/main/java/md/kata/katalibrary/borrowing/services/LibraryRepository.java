package md.kata.katalibrary.borrowing.services;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.borrowing.model.Book;

public interface LibraryRepository {
  Optional<Book> findBookById(UUID bookId);

  void returnBook(Book book);

  void borrowBook(Book book);
}
