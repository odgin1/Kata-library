package md.kata.katalibrary.bookinventory.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import md.kata.katalibrary.bookinventory.jpa.entity.Author;

public interface AuthorRepositoryJpa extends JpaRepository<Author, UUID> {
  List<Author> findByLastName(String lastName);

  List<Author> findByFirstName(String firstName);
}
