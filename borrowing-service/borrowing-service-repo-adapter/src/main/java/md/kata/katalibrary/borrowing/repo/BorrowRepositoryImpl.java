package md.kata.katalibrary.borrowing.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.borrowing.jpa.BorrowingRepositoryJpa;
import md.kata.katalibrary.borrowing.jpa.entity.BookBorrowing;
import md.kata.katalibrary.borrowing.model.Book;
import md.kata.katalibrary.borrowing.model.BookBorrow;
import md.kata.katalibrary.borrowing.services.BorrowRepository;

public class BorrowRepositoryImpl implements BorrowRepository {

  private final BorrowingRepositoryJpa borrowingRepositoryJpa;

  public BorrowRepositoryImpl(BorrowingRepositoryJpa borrowingRepositoryJpa) {
    this.borrowingRepositoryJpa = borrowingRepositoryJpa;
  }

  @Override
  public void borrow(Book book, UUID userId) {
    borrowingRepositoryJpa.save(new BookBorrowing(book.id(), userId));
  }

  public List<BookBorrow> findNotReturnedBorrowings(UUID userId) {
    List<BookBorrowing> activeBorrowingsByUser = borrowingRepositoryJpa.findActiveBorrowingsByUser(userId);
    return activeBorrowingsByUser.stream()
        .map(bookBorrowing -> new BookBorrow(
            bookBorrowing.getId(),
            bookBorrowing.getUserId(),
            bookBorrowing.getUserId()
            ))
        .toList();
  }

  public void markAsReturned(UUID borrowingId) {
    Optional<BookBorrowing> byId = borrowingRepositoryJpa.findById(borrowingId);
    byId.ifPresent(bookBorrowing -> {
      bookBorrowing.returnNow();
      borrowingRepositoryJpa.save(bookBorrowing);
    });
  }
}
