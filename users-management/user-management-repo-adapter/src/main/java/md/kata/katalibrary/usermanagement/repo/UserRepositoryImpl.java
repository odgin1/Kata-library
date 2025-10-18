package md.kata.katalibrary.usermanagement.repo;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.usermanagement.services.UserRepository;
import md.kata.katalibrary.usermanagement.jpa.UserRepositoryJpa;
import md.kata.katalibrary.usermanagement.services.model.User;


public class UserRepositoryImpl implements UserRepository {

  private final UserRepositoryJpa userRepositoryJpa;

  public UserRepositoryImpl(UserRepositoryJpa userRepositoryJpa) {
    this.userRepositoryJpa = userRepositoryJpa;
  }

  @Override
  public Optional<User> findById(UUID userId) {
    return userRepositoryJpa.findById(userId)
        .map(userAccount -> new User(userAccount.getId(), userAccount.getName()));
  }
}
