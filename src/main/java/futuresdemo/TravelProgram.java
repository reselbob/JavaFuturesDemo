package futuresdemo;

import futuresdemo.travel.Airline;
import futuresdemo.travel.CarRental;
import futuresdemo.travel.Confirmation;
import futuresdemo.travel.Hotel;
import futuresdemo.utils.DateConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TravelProgram {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executor = Executors.newFixedThreadPool(3);

    // Take a timestamp before the try statement is executed
    long startTime = System.currentTimeMillis();

    // Print to the start time to system output
    System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));

    System.out.println(
        "Booking hotel, airline, and car rental reservations in parallel using CompletableFuture.\n");

    CompletableFuture<Confirmation> hotelFuture =
        CompletableFuture.supplyAsync(() -> new Hotel(10).book(), executor);
    CompletableFuture<Confirmation> airlineFuture =
        CompletableFuture.supplyAsync(() -> new Airline(2).book(), executor);
    CompletableFuture<Confirmation> carRentalFuture =
        CompletableFuture.supplyAsync(() -> new CarRental(5).book(), executor);

    // run all the futures using allOf
    CompletableFuture<Void> combinedFuture =
        CompletableFuture.allOf(hotelFuture, airlineFuture, carRentalFuture);

    List<Confirmation> confirmations = new ArrayList<>();

    confirmations.add(hotelFuture.get());
    confirmations.add(airlineFuture.get());
    confirmations.add(carRentalFuture.get());

    System.out.println("\nConfirmations:\n");

    // iterate through the list of confirmations and print the id, message and business type
    for (Confirmation confirmation : confirmations) {
      System.out.println(
          "Confirmation id: "
              + confirmation.getId()
              + " message: "
              + confirmation.getMessage()
              + " business type: "
              + confirmation.getBusinessType());
    }

    // Take a timestamp at the end of the try statement
    long endTime = System.currentTimeMillis();
    // Print the end time to system output
    System.out.println("End time: " + DateConverter.convertToHumanReadableTime(endTime));

    // Print the difference between the end time and the start time to system output in seconds
    System.out.println("Total time: " + (endTime - startTime) / 1000 + " seconds");

    // Shut down the executorService
    executor.shutdown();
  }
}
