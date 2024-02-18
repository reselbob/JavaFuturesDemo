package futuresdemo.commerce;

public class Shipper {
  public Order ship(Order order) {
    int sleepTime = 3000;
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.SHIPPED);
    String str =
        String.format("Shipped: Order %s, took %d seconds", order.getId(), sleepTime / 1000);
    System.out.println(str);
    return order;
  }
}
