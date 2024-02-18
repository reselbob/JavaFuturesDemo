package futuresdemo.commerce;

import futuresdemo.utils.Mocks;

public class Dispatcher {
    public Order getOrder() {
        int sleepTime = 1000;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = Mocks.getRandomOrder();
        String str = String.format("Dispatched: Order %s, took %d seconds", order.getId(), sleepTime / 1000);
        System.out.println(str);
        return order;
    }
}
