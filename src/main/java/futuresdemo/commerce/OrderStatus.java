package futuresdemo.commerce;

public enum OrderStatus {
  PENDING,
  CONFIRMED,
  CANCELLED,
  SHIPPED,
  DELIVERED,
  PAID;

  // add a method that returns the order status as a string
  public String toString() {
    return this.name().toLowerCase();
  }
}
