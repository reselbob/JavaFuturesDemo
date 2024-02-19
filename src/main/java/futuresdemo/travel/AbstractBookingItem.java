package futuresdemo.travel;

import futuresdemo.utils.DateConverter;

public abstract class AbstractBookingItem implements Bookable {
  private final long waitTime;

  protected AbstractBookingItem(long waitTime) {
    this.waitTime = waitTime;
  }

  public abstract BusinessType getBusinessType();

  @Override
  public Confirmation book() {
    // Print  a timestamp in seconds
    long startTime = System.currentTimeMillis();

    System.out.println(
        this.getClassName()
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

    return new ConfirmationImpl(getClassName() + " booking completed", getBusinessType());
  }

  public String getClassName() {
    return this.getClass().getSimpleName();
  }
}
