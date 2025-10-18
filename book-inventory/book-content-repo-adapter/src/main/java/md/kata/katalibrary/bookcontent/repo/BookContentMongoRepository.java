package md.kata.katalibrary.bookcontent.repo;

import java.util.Optional;
import java.util.UUID;

public interface BookContentMongoRepository {
  void putContent(UUID bookId, String textContent);

  Optional<String> getContent(UUID bookId);
}
