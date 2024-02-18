package futuresdemo;

import futuresdemo.commerce.*;
import futuresdemo.commerce.BizProcess;
import futuresdemo.commerce.Confirmation;
import futuresdemo.travel.Hotel;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class SequenceCommerceProgram {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));
        System.out.println("Running a business process\n");
        ExecutorService executor = Executors.newFixedThreadPool(7);

        CompletableFuture<Order> orderFuture =
                CompletableFuture.supplyAsync(() -> new Dispatcher().getOrder(), executor);
        Order order = orderFuture.get();
        reportOrderStatus(order);

        Order orderFromDispatcher = order;

        CompletableFuture<Order> paymentFuture =
                CompletableFuture.supplyAsync(() -> new Payment().pay(orderFromDispatcher), executor);
        order = paymentFuture.get();
        reportOrderStatus(order);

        Order orderFromPayment = order;

        CompletableFuture<Order> shipperFuture =
                CompletableFuture.supplyAsync(() -> new Shipper().ship(orderFromPayment), executor);
        order = shipperFuture.get();
        reportOrderStatus(order);

        Order orderFromShipper = order;

        CompletableFuture<Order> deliveryFuture =
                CompletableFuture.supplyAsync(() -> new Delivery().deliver(orderFromShipper), executor);
        order = deliveryFuture.get();
        reportOrderStatus(order);

        Order orderFromDelivery= order;
        CompletableFuture<Order> confirmationFuture =
                CompletableFuture.supplyAsync(() -> new Confirmation().confirm(orderFromDelivery), executor);
        order = confirmationFuture.get();
        reportOrderStatus(order);

        long endTime = System.currentTimeMillis();
        System.out.println("End time: " + DateConverter.convertToHumanReadableTime(endTime));
        System.out.println("Total time: " + (endTime - startTime) / 1000 + " seconds");
        executor.shutdown();
    }

    private static void reportOrderStatus(Order order) {
        String str = String.format("Order: %s is %s", order.getId(), order.getStatus());
        System.out.println(str);
    }
}
