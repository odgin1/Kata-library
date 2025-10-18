package md.kata.katalibrary.borrowing.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(indexes = @Index(columnList = "userId"))
public class BookBorrowing {
  @Id
  @GeneratedValue
  private UUID id;
  private UUID userId;
  private UUID bookId;
  private Instant borrowedAt;
  private Instant returnedAt; // null => currently borrowed


  protected BookBorrowing() {
  }

  public BookBorrowing(UUID userId, UUID bookId) {
    this.userId = userId;
    this.bookId = bookId;
    this.borrowedAt = Instant.now();
  }


  public boolean isActive() {
    return returnedAt == null;
  }

  public void returnNow() {
    this.returnedAt = Instant.now();
  }

  public UUID getId() {
    return id;
  }

  public UUID getBookId() {
    return bookId;
  }

  public UUID getUserId() {
    return userId;
  }
}
