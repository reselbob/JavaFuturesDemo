package futuresdemo.trip;

public class Hotel extends BookingItem {
  public Hotel(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public String getClassName() {
    return this.getClass().getSimpleName();
  }
}
