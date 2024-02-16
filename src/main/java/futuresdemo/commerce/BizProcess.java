package futuresdemo.commerce;

import futuresdemo.utils.Mocks;

public class BizProcess {

  public static Order getOrder() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return Mocks.getRandomOrder();
  }

  public static Order payOrder(Order order) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.PAID);
    return order;
  }

  public static Order shipOrder(Order order) {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.SHIPPED);
    return order;
  }

  public static Order deliverOrder(Order order) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.DELIVERED);
    return order;
  }

  public static Order confirmOrder(Order order) {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.CONFIRMED);
    return order;
  }
}
