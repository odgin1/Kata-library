package md.kata.katalibrary.borrowing.repo;

import java.util.Optional;
import java.util.UUID;

import md.kata.katalibrary.borrowing.model.User;
import md.kata.katalibrary.borrowing.services.UserRepository;
import md.kata.katalibrary.usermanagement.services.UserServiceImpl;


public class UserRepositoryImpl implements UserRepository {

  UserServiceImpl userServiceImpl;

  @Override
  public Optional<User> findById(UUID userId){
    return userServiceImpl.findById(userId)
        .map(user -> new User(user.userId(), user.name()));
  }
}
