package futuresdemo.commerce;

public class Delivery {
    public Order deliver(Order order) {
        int sleepTime = 10000;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        order.setStatus(OrderStatus.DELIVERED);
        String str = String.format("Delivery: Order %s, took %d seconds", order.getId(), sleepTime / 1000);
        System.out.println(str);
        return order;
    }
}
