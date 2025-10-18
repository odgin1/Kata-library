package md.kata.katalibrary.usermanagement.services;

import md.kata.katalibrary.usermanagement.services.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
  Optional<User> findById(UUID userId);
}
