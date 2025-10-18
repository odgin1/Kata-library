package md.kata.katalibrary.borrowing.services;

import java.util.List;
import java.util.UUID;

import md.kata.katalibrary.borrowing.model.Book;
import md.kata.katalibrary.borrowing.model.BookBorrow;

public interface BorrowRepository {
  void borrow(Book book, UUID userId);

  List<BookBorrow> findNotReturnedBorrowings(UUID userId);

  void markAsReturned(UUID id);
}
