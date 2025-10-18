package md.kata.katalibrary.usermanagement.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity
public class UserAccount {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;

  protected UserAccount() {
  }

  public UserAccount(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
