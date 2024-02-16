package futuresdemo.utils;

import com.github.javafaker.Faker;
import futuresdemo.commerce.Customer;
import futuresdemo.commerce.Order;
import java.math.BigDecimal;

public class Mocks {
  private static final Faker faker = new Faker();

  public static String randomName() {
    return faker.name().fullName();
  }

  public static String randomAddress() {
    return faker.address().fullAddress();
  }

  public static String randomPhoneNumber() {
    return faker.phoneNumber().phoneNumber();
  }

  public static String randomEmail() {
    return faker.internet().emailAddress();
  }

  public static Customer getRandomCustomer() {
    return new Customer(randomName(), randomName(), randomEmail(), randomPhoneNumber());
  }

  public static Order getRandomOrder() {
    return new Order(
        getRandomCustomer(),
        randomProductName(),
        faker.number().numberBetween(1, 10),
        BigDecimal.valueOf(faker.number().randomDouble(2, 2, 10)));
  }

  // create a method that returns a random product name
  public static String randomProductName() {
    String[] products = {"Peanuts", "Cracker Jack", "Popcorn"};
    return products[faker.number().numberBetween(0, 2)];
  }
}
