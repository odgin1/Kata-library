package md.kata.katalibrary.usermanagement.jpa;

import md.kata.katalibrary.usermanagement.jpa.entity.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJpa extends JpaRepository<UserAccount, UUID> {}
