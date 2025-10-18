package md.kata.katalibrary.book.web;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import md.kata.katalibrary.book.models.Author;
import md.kata.katalibrary.book.models.Book;
import md.kata.katalibrary.book.services.LibraryInventoryServiceImpl;

@RestController
@RequestMapping("/api/books")
public class LibraryInventoryController {

  private final LibraryInventoryServiceImpl libraryInventoryService;

  public LibraryInventoryController(LibraryInventoryServiceImpl libraryInventoryService) {
    this.libraryInventoryService = libraryInventoryService;
  }

  @PostMapping
  public ResponseEntity<Void> createBook(@RequestBody Book book) {
    libraryInventoryService.addBook(book);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateBook(@PathVariable("id") UUID id, @RequestBody Book payload) {
    String isbn = payload.isbn();
    String title = payload.title();
    List<Author> authors = payload.author();
    Book toUpdate = new Book(id, isbn, title, authors != null ? authors : List.of());
    libraryInventoryService.addBook(toUpdate);
    return ResponseEntity.noContent().build();
  }
}
