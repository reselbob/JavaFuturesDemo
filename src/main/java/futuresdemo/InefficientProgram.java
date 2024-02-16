package futuresdemo;

import futuresdemo.trip.Airline;
import futuresdemo.trip.CarRental;
import futuresdemo.trip.Hotel;
import futuresdemo.trip.Result;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class InefficientProgram {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
      long startTime = System.currentTimeMillis();
      System.out.println("Start time: " + DateConverter.convertToHumanReadableTime(startTime));
      System.out.println("Booking hotel, airline, and car rental inefficiently");

      ExecutorService executorService = Executors.newFixedThreadPool(3);

    // Use executorService to submit an instance of the Hotel class to the thread pool and call
    Future<Result> hotelFuture = executorService.submit(() -> new Hotel(10).book());
    Future<Result> airlineFuture = executorService.submit(() -> new Airline(2).book());
    Future<Result> carRentalFuture =
        executorService.submit(() -> new CarRental(5).book());

    Result hotelResult = hotelFuture.get();
    Result airlineResult = airlineFuture.get();
    Result carRentalResult = carRentalFuture.get();

    try {
      // Hotel result
      System.out.println(hotelResult.getMessage());
      // Airline result
      System.out.println(airlineResult.getMessage());
      // Car Rental result
      System.out.println(carRentalResult.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }

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
