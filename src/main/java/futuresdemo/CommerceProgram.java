package futuresdemo;

import futuresdemo.commerce.BizProcess;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class CommerceProgram {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    long startTime = System.currentTimeMillis();
    System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));
    System.out.println("Running a business process\n");
    ExecutorService executor = Executors.newFixedThreadPool(3);

    CompletableFuture.supplyAsync(BizProcess::getOrder, executor)
        .thenApply(
            order -> {
              String str = String.format("Order: %s is %s", order.getId(), order.getStatus());
              System.out.println(str);
              return order;
            })
        .thenApply(order -> BizProcess.payOrder(order))
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApply(order -> BizProcess.shipOrder(order))
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApply(order -> BizProcess.deliverOrder(order))
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApply(order -> BizProcess.confirmOrder(order))
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
