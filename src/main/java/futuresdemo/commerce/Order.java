package futuresdemo.commerce;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {
  private final UUID id;
  private final Customer customer;
  private final String name;
  private final int quantity;

  private OrderStatus status;

  private final BigDecimal price;

  public Order(Customer customer, String name, int quantity, BigDecimal price) {
    this.id = UUID.randomUUID();
    this.customer = customer;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.status = OrderStatus.PENDING;
  }

  public UUID getId() {
    return this.id;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public String getName() {
    return this.name;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public OrderStatus getStatus() {
    return this.status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}
