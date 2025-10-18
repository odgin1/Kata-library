package md.kata.katalibrary.borrowing.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.borrowing.model.Book;

import md.kata.katalibrary.borrowing.model.BookBorrow;

import md.kata.katalibrary.borrowing.model.User;

import org.springframework.transaction.annotation.Transactional;

public class BorrowServiceImpl {

  private final LibraryRepository libraryRepo;
  private final BorrowRepository borrowRepo;
  private final UserRepository usersRepo;

  public BorrowServiceImpl(LibraryRepository libraryRepo, BorrowRepository borrowRepo, UserRepository usersRepo) {
    this.libraryRepo = libraryRepo;
    this.borrowRepo = borrowRepo;
    this.usersRepo = usersRepo;
  }

  @Transactional
  public void borrow(UUID userId, UUID bookId) {
    usersRepo.findById(userId).orElseThrow();
    Book book = libraryRepo.findBookById(bookId).orElseThrow();
    libraryRepo.borrowBook(book);
    borrowRepo.borrow(book, userId);
  }

  @Transactional
  public void returnBook(UUID userId, UUID bookId) {
    Book book = libraryRepo.findBookById(bookId).orElseThrow();
    List<BookBorrow> actives = borrowRepo.findNotReturnedBorrowings(userId);
    BookBorrow bookBorrow = actives.stream().filter(l -> l.bookId().equals(bookId)).findFirst()
        .orElseThrow(() -> new IllegalStateException("No active loan for this book"));
    borrowRepo.markAsReturned(bookBorrow.id());
    libraryRepo.returnBook(book);
  }

  public List<Book> listBorrowedBooks(UUID userId) {
    Optional<User> optionalUser = usersRepo.findById(userId);
    if (optionalUser.isEmpty()) {
      throw new IllegalArgumentException("User not found");
    }
    return borrowRepo.findNotReturnedBorrowings(userId)
        .stream()
        .map(bookBorrow -> libraryRepo.findBookById(bookBorrow.bookId()).orElseThrow())
        .toList();
  }
}
