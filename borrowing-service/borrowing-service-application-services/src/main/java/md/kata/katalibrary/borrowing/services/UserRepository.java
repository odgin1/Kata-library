package md.kata.katalibrary.borrowing.services;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.borrowing.model.User;

public interface UserRepository {
  Optional<User> findById(UUID userId);
}
