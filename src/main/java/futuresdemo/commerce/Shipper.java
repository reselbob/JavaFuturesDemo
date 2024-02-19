package futuresdemo.commerce;

import futuresdemo.utils.DateConverter;

public class Shipper extends AbstractCommerceActivity {
  public Order ship(Order order) {
    int sleepTime = 3000;
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.SHIPPED);
    String endTime = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
    String str =
        String.format(
            "Shipped: Order %s, ended at %s and took %d seconds",
            order.getId(), endTime, sleepTime / 1000);
    System.out.println(str);
    return order;
  }
}
