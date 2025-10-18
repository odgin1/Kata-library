package md.kata.katalibrary.borrowing.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import md.kata.katalibrary.borrowing.jpa.entity.BookBorrowing;

import org.springframework.data.jpa.repository.Query;

public interface BorrowingRepositoryJpa extends JpaRepository<BookBorrowing, UUID> {

  List<BookBorrowing> findByUserId(UUID userId);

  @Query("SELECT b FROM BookBorrowing b WHERE b.userId = :userId AND b.returnedAt IS NULL")
  List<BookBorrowing> findActiveBorrowingsByUser(UUID userId);

}
