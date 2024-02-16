package futuresdemo.travel;

public class Hotel extends BookingItem {
  public Hotel(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public String getClassName() {
    return this.getClass().getSimpleName();
  }

  @Override
  public BusinessType getBusinessType() {
    return BusinessType.HOTEL;
  }
}
