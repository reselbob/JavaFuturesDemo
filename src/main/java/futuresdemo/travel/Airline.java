package futuresdemo.travel;

public class Airline extends AbstractBookingItem {
  public Airline(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public BusinessType getBusinessType() {
    return BusinessType.AIRLINE;
  }
}
