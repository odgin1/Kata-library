package md.kata.katalibrary.book.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.book.models.Author;
import md.kata.katalibrary.book.models.AuthorBooks;
import md.kata.katalibrary.book.models.AuthorRepository;
import md.kata.katalibrary.book.models.Book;
import md.kata.katalibrary.book.models.BookContentRepository;
import md.kata.katalibrary.book.models.BookRepository;

import org.springframework.transaction.annotation.Transactional;

public class LibraryInventoryServiceImpl {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final BookContentRepository bookContentRepository;

  public LibraryInventoryServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookContentRepository bookContentRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.bookContentRepository = bookContentRepository;
  }

  public AuthorBooks findByAuthorId(UUID authorId) {
    return authorRepository.findByAuthorId(authorId);
  }

  public List<Author> findByFirstName(String firstName) {
    return authorRepository.findByFirstName(firstName);
  }

  public List<Author> findByLastName(String lastName) {
    return authorRepository.findByLastName(lastName);
  }

  public Optional<Book> findByIsbn(String isbn) {
    return bookRepository.findByIsbn(isbn);
  }

  public Optional<Book> findByBookId(UUID bookId) {
    return bookRepository.findByBookId(bookId);
  }

  public void takeBook(UUID bookId) {
    bookRepository.takeBook(bookId);
  }

  public void returnBook(UUID bookId) {
    bookRepository.returnBook(bookId);
  }

  public void put(UUID bookId, String textContent) {
    bookContentRepository.putContent(bookId, textContent);
  }

  public Optional<String> get(UUID bookId) {
    return bookContentRepository.getContent(bookId);
  }

  @Transactional
  public void addBook(Book book) {
    bookRepository.addNewBook(book);
  }
}
