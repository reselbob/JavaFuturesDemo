package futuresdemo.commerce;

import futuresdemo.utils.DateConverter;

public class Payment extends AbstractCommerceActivity {
  public Order pay(Order order) {
    int sleepTime = 2000;
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus(OrderStatus.PAID);

    String endTime = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
    String str =
        String.format(
            "Shipped: Order %s, ended at %s and took %d seconds",
            order.getId(), endTime, sleepTime / 1000);
    System.out.println(str);
    return order;
  }
}
