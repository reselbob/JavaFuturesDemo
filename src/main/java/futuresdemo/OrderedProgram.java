package futuresdemo;

import futuresdemo.trip.Airline;
import futuresdemo.trip.CarRental;
import futuresdemo.trip.Hotel;
import futuresdemo.trip.Result;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class OrderedProgram {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
      long startTime = System.currentTimeMillis();
      System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));
      System.out.println("Booking hotel, airline, and car in order\n");
      ExecutorService executor = Executors.newFixedThreadPool(3);

      CompletableFuture.supplyAsync(() -> new Hotel(10).book(), executor)
              .thenApply(result -> {
                  System.out.println(result.getMessage());
                  return result;
              })
              .thenApply(result ->  new Airline(2).book())
              .thenApply(result -> {
                  System.out.println(result.getMessage());
                  return result;
              })
              .thenApply(result ->  new CarRental(5).book())
              .thenApply(result -> {
                  System.out.println(result.getMessage());
                  return result;
              })
              .thenApply(result -> {
                  long endTime = System.currentTimeMillis();
                  System.out.println("End time: " + DateConverter.convertToHumanReadableTime(endTime));
                  System.out.println("Total time: " + (endTime - startTime) / 1000 + " seconds");
                  executor.shutdown();
                  return result;
              });
  }
}
