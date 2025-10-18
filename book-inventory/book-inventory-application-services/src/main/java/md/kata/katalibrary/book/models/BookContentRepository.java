package md.kata.katalibrary.book.models;

import java.util.Optional;
import java.util.UUID;

public interface BookContentRepository {
  void putContent(UUID bookId, String textContent);

  Optional<String> getContent(UUID bookId);
}
