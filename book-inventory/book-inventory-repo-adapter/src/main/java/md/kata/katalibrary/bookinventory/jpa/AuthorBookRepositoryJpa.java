package md.kata.katalibrary.bookinventory.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import md.kata.katalibrary.bookinventory.jpa.entity.AuthorBook;

public interface AuthorBookRepositoryJpa extends JpaRepository<AuthorBook, UUID> {
  List<AuthorBook> findByAuthorId(UUID authorId);

  List<AuthorBook> findByBookId(UUID bookId);
}
