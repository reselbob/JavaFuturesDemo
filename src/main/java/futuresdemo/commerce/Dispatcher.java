package futuresdemo.commerce;

import futuresdemo.utils.DateConverter;
import futuresdemo.utils.Mocks;

public class Dispatcher extends AbstractCommerceActivity {
  public Order getOrder() {
    int sleepTime = 1000;
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Order order = Mocks.getRandomOrder();

    String endTime = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
    String str =
        String.format(
            "Shipped: Order %s, ended at %s and took %d seconds",
            order.getId(), endTime, sleepTime / 1000);
    System.out.println(str);
    return order;
  }
}
