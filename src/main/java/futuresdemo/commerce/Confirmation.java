package futuresdemo.commerce;

public class Confirmation {
  public Order confirm(Order order) {
    int sleepTime = 1000;
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.CONFIRMED);
    String str =
        String.format("Confirmation: Order %s, took %d seconds", order.getId(), sleepTime / 1000);
    System.out.println(str);
    return order;
  }
}
