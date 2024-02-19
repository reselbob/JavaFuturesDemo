package futuresdemo.travel;

public class Hotel extends AbstractBookingItem {
  public Hotel(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public BusinessType getBusinessType() {
    return BusinessType.HOTEL;
  }
}
