package futuresdemo;

import futuresdemo.commerce.BizProcess;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class ChainedCommerceProgram {
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
        .thenApplyAsync(BizProcess::payOrder, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(BizProcess::shipOrder, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(BizProcess::deliverOrder, executor)
        .thenApply(
            order -> {
              String stamp = DateConverter.convertToHumanReadableTime(System.currentTimeMillis());
              String str =
                  String.format("Order: %s is %s at %s", order.getId(), order.getStatus(), stamp);
              System.out.println(str);
              return order;
            })
        .thenApplyAsync(BizProcess::confirmOrder, executor)
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
