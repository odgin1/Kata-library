package md.kata.katalibrary.book.models;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository {
  List<Author> findByFirstName(String firstName);

  List<Author> findByLastName(String lastName);

  AuthorBooks findByAuthorId(UUID authorId);
}
