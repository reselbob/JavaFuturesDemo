package futuresdemo.travel;

public class Airline extends BookingItem {
  public Airline(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public String getClassName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public BusinessType getBusinessType() {
    return BusinessType.AIRLINE;
  }
}
