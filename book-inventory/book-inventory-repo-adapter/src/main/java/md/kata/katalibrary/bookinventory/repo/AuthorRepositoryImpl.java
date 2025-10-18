package md.kata.katalibrary.bookinventory.repo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import md.kata.katalibrary.book.models.AuthorRepository;
import md.kata.katalibrary.bookinventory.jpa.AuthorBookRepositoryJpa;
import md.kata.katalibrary.bookinventory.jpa.AuthorRepositoryJpa;
import md.kata.katalibrary.bookinventory.jpa.entity.Author;
import md.kata.katalibrary.bookinventory.jpa.entity.AuthorBook;
import md.kata.katalibrary.bookinventory.jpa.entity.Book;

public class AuthorRepositoryImpl implements AuthorRepository {

  private final AuthorBookRepositoryJpa authorBookRepositoryJpa;
  private final AuthorRepositoryJpa authorRepositoryJpa;

  public AuthorRepositoryImpl(AuthorBookRepositoryJpa authorBookRepositoryJpa, AuthorRepositoryJpa authorRepositoryJpa) {
    this.authorBookRepositoryJpa = authorBookRepositoryJpa;
    this.authorRepositoryJpa = authorRepositoryJpa;
  }

  public List<md.kata.katalibrary.book.models.Author> findByFirstName(String firstName) {
    List<Author> authors = authorRepositoryJpa.findByFirstName(firstName);
    return authors.stream().map(a -> new md.kata.katalibrary.book.models.Author(a.getId(), a.getFirstName(), a.getLastName())).toList();
  }

  public List<md.kata.katalibrary.book.models.Author> findByLastName(String lastName) {
    List<Author> authors = authorRepositoryJpa.findByLastName(lastName);
    return authors.stream().map(a -> new md.kata.katalibrary.book.models.Author(a.getId(), a.getFirstName(), a.getLastName())).toList();
  }

  public md.kata.katalibrary.book.models.AuthorBooks findByAuthorId(UUID authorId) {
    List<AuthorBook> booksByAuthor = authorBookRepositoryJpa.findByAuthorId(authorId);
    Set<md.kata.katalibrary.book.models.Book> booksCollection = new HashSet<>();
    md.kata.katalibrary.book.models.Author author = null;
    for (int i = 0; i < booksByAuthor.size(); i++) {
      AuthorBook authorBook = booksByAuthor.get(i);
      Book book = authorBook.getBook();
      booksCollection.add(new md.kata.katalibrary.book.models.Book(book.getId(), book.getIsbn(), book.getTitle()));
      if (i == 0) {
        Author authorEntity = authorBook.getAuthor();
        author = new md.kata.katalibrary.book.models.Author(authorEntity.getId(), authorEntity.getFirstName(), authorEntity.getLastName());
      }
    }

    return new md.kata.katalibrary.book.models.AuthorBooks(author, booksCollection);
  }

}
