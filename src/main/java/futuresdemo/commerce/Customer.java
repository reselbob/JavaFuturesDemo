package futuresdemo.commerce;

import java.util.UUID;

public class Customer {
  private final UUID id = UUID.randomUUID();
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phone;

  public Customer(String firstName, String lastName, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public UUID getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhone() {
    return this.phone;
  }
}
