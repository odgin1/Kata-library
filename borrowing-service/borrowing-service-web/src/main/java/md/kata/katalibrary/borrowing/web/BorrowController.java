package md.kata.katalibrary.borrowing.web;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import md.kata.katalibrary.borrowing.model.Book;
import md.kata.katalibrary.borrowing.services.BorrowServiceImpl;

@RestController
@RequestMapping("/api")
public class BorrowController {

  private final BorrowServiceImpl borrowService;

  public BorrowController(BorrowServiceImpl borrowService) {
    this.borrowService = borrowService;
  }

  @PostMapping("/borrows/users/{userId}/books/{bookId}")
  public ResponseEntity<Void> borrow(@PathVariable UUID userId, @PathVariable UUID bookId) {
    borrowService.borrow(userId, bookId);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/borrow-returns/users/{userId}/books/{bookId}")
  public ResponseEntity<Void> returnBook(@PathVariable UUID userId, @PathVariable UUID bookId) {
    borrowService.returnBook(userId, bookId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/borrows/users/{userId}")
  public ResponseEntity<List<Book>> listBorrowedBooks(@PathVariable UUID userId) {
    List<Book> books = borrowService.listBorrowedBooks(userId);
    return ResponseEntity.ok(books);
  }
}
