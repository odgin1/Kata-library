package md.kata.katalibrary.usermanagement.services;

import md.kata.katalibrary.usermanagement.services.model.User;

import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findById(UUID userId){
    return userRepository.findById(userId);
  }

}
