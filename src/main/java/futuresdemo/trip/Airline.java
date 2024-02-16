package futuresdemo.trip;

public class Airline extends BookingItem {
  public Airline(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public String getClassName() {
    return this.getClass().getSimpleName();
  }
}
