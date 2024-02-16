package futuresdemo.trip;

import futuresdemo.utils.DateConverter;

public abstract class BookingItem implements Bookable {
  private final long waitTime;

  public abstract String getClassName();

  public BookingItem(long waitTimeInSeconds) {
    this.waitTime = waitTimeInSeconds;
  }

  @Override
  public Result book() {
    // Print  a timestamp in seconds
    long startTime = System.currentTimeMillis();

    System.out.println(
        getClassName()
            + " booking started at: "
            + DateConverter.convertToHumanReadableTime(startTime));

    // Wait for 15 seconds
    try {
      Thread.sleep(this.waitTime * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long endTime = System.currentTimeMillis();
    System.out.println(
        getClassName()
            + " booking ended at: "
            + DateConverter.convertToHumanReadableTime(endTime)
            + " and took "
            + (endTime - startTime) / 1000
            + " seconds.");

    return new ResultImpl(getClassName() + " booking completed");
  }
}
