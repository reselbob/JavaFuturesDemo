package futuresdemo;

import futuresdemo.trip.Airline;
import futuresdemo.trip.CarRental;
import futuresdemo.trip.Hotel;
import futuresdemo.trip.Result;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class EfficientProgram {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // Take a timestamp before the try statement is executed
    long startTime = System.currentTimeMillis();

    // Print to the start time to system output
    System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));

    System.out.println(
        "Booking hotel, airline, and car rental efforts in parallel using CompletableFuture");

    CompletableFuture<Result> hotelFuture =
        CompletableFuture.supplyAsync(() -> new Hotel(10).book());
    CompletableFuture<Result> airlineFuture =
        CompletableFuture.supplyAsync(() -> new Airline(2).book());
    CompletableFuture<Result> carRentalFuture =
        CompletableFuture.supplyAsync(() -> new CarRental(5).book());

    Result result = hotelFuture.get();

    // run all the futures using allOf
    Void combinedFuture =
        CompletableFuture.allOf(hotelFuture, airlineFuture, carRentalFuture).get();

    // Take a timestamp at the end of the try statement
    long endTime = System.currentTimeMillis();
    // Print the end time to system output
    System.out.println("End time: " + DateConverter.convertToHumanReadableTime(endTime));

    // Print the difference between the end time and the start time to system output in seconds
    System.out.println("Total time: " + (endTime - startTime) / 1000 + " seconds");

    // Shut down the executorService
    executorService.shutdown();
  }
}
