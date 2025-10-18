package md.kata.katalibrary.borrowing.repo;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.book.services.LibraryInventoryServiceImpl;
import md.kata.katalibrary.borrowing.model.Book;
import md.kata.katalibrary.borrowing.services.LibraryRepository;

public class LibraryRepositoryImpl implements LibraryRepository {

  LibraryInventoryServiceImpl libraryInventoryService;

  public Optional<md.kata.katalibrary.borrowing.model.Book> findBookById(UUID bookId) {
    return libraryInventoryService.findByBookId(bookId)
        .map(book -> new md.kata.katalibrary.borrowing.model.Book(book.id()));
  }

  public void returnBook(Book book) {
    libraryInventoryService.returnBook(book.id());
  }

  public void borrowBook(Book book){
    libraryInventoryService.takeBook(book.id());
  }
}
