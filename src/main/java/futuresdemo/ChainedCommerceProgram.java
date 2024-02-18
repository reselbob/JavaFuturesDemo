package futuresdemo;

import futuresdemo.commerce.*;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class ChainedCommerceProgram {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));
    System.out.println("Running a chained business process\n");
    ExecutorService executor = Executors.newFixedThreadPool(7);
    Dispatcher dispatcher = new Dispatcher();
    Payment payment = new Payment();
    Shipper shipper = new Shipper();
    Delivery delivery = new Delivery();
    Confirmation confirmation = new Confirmation();

    CompletableFuture.supplyAsync(dispatcher::getOrder, executor)
        .thenApply(
            order -> {
              String str = String.format("Order: %s is %s", order.getId(), order.getStatus());
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(payment::pay, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(shipper::ship, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(delivery::deliver, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(confirmation::confirm, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApply(
            result -> {
              long endTime = System.currentTimeMillis();
              System.out.println("End time: " + DateConverter.convertToHumanReadableTime(endTime));
              System.out.println("Total time: " + (endTime - startTime) / 1000 + " seconds");
              executor.shutdown();
              return result;
            });
  }
}
