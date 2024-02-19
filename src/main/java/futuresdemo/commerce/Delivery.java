package futuresdemo.commerce;

import futuresdemo.utils.DateConverter;

public class Delivery extends AbstractCommerceActivity {
  public Order deliver(Order order) {
    int sleepTime = 10000;
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.DELIVERED);

    String endTime = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
    String str =
        String.format(
            "Shipped: Order %s, ended at %s and took %d seconds",
            order.getId(), endTime, sleepTime / 1000);
    System.out.println(str);

    return order;
  }
}
