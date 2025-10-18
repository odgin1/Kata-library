package md.kata.katalibrary.bookcontent.repo;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.book.models.BookContentRepository;

public class BookContentRepositoryImpl implements BookContentRepository {

  private final BookContentMongoRepository bookContentMongoRepository;

  public BookContentRepositoryImpl(BookContentMongoRepository bookContentMongoRepository) {
    this.bookContentMongoRepository = bookContentMongoRepository;
  }

  @Override
  public void putContent(UUID bookId, String textContent) {
    bookContentMongoRepository.putContent(bookId, textContent);
  }

  @Override
  public Optional<String> getContent(UUID bookId) {
    return bookContentMongoRepository.getContent(bookId);
  }
}
