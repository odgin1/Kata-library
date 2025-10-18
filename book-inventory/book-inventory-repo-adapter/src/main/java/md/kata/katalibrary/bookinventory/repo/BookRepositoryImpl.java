package md.kata.katalibrary.bookinventory.repo;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.bookinventory.jpa.BookRepositoryJpa;
import md.kata.katalibrary.bookinventory.jpa.entity.Book;

public class BookRepositoryImpl implements md.kata.katalibrary.book.models.BookRepository {

  private final BookRepositoryJpa bookRepositoryJpa;

  public BookRepositoryImpl(BookRepositoryJpa bookRepositoryJpa) {
    this.bookRepositoryJpa = bookRepositoryJpa;
  }

  @Override
  public Optional<md.kata.katalibrary.book.models.Book> findByIsbn(String isbn) {
    return bookRepositoryJpa.findByIsbn(isbn).map(b ->
        new md.kata.katalibrary.book.models.Book(b.getId(), b.getIsbn(), b.getTitle())
    );
  }

  @Override
  public Optional<md.kata.katalibrary.book.models.Book> findByBookId(UUID bookId) {
    return bookRepositoryJpa.findById(bookId).map(b ->
        new md.kata.katalibrary.book.models.Book(b.getId(), b.getIsbn(), b.getTitle())
    );
  }

  @Override
  public void returnBook(UUID bookId) {
    Optional<Book> bookOpt = bookRepositoryJpa.findById(bookId);
    bookOpt.ifPresent(foundBook -> {
      foundBook.returnOne();
      bookRepositoryJpa.save(foundBook);
    });
  }

  @Override
  public void takeBook(UUID bookId) {
    Optional<Book> bookOpt = bookRepositoryJpa.findById(bookId);
    bookOpt.ifPresent(foundBook -> {
      foundBook.takeOne();
      bookRepositoryJpa.save(foundBook);
    });
  }

  @Override
  public void addNewBook(md.kata.katalibrary.book.models.Book book) {
    Optional<Book> bookOpt = bookRepositoryJpa.findByIsbn(book.isbn());
    bookOpt.ifPresentOrElse(foundBook -> {
          foundBook.addNewBookCopy();
          bookRepositoryJpa.save(foundBook);
        },
        () -> {
          bookRepositoryJpa.save(new Book(book.title(), book.isbn(), 1));
        }
    );
  }
}
