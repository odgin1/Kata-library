package md.kata.katalibrary.bookinventory.jpa;

import md.kata.katalibrary.bookinventory.jpa.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepositoryJpa extends JpaRepository<Book, UUID> {
  Optional<Book> findByIsbn(String isbn);
}
