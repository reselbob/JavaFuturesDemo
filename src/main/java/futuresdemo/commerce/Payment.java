package futuresdemo.commerce;

public class Payment {
    public Order pay(Order order) {
        int sleepTime = 2000;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        order.setStatus(OrderStatus.PAID);
        String str = String.format("Payment: Order %s, took %d seconds", order.getId(), sleepTime / 1000);
        System.out.println(str);
        return order;
    }
}
