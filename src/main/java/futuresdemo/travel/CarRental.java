package futuresdemo.travel;

public class CarRental extends BookingItem {
  public CarRental(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  @Override
  public String getClassName() {
    return this.getClass().getSimpleName();
  }

  public BusinessType getBusinessType() {
    return BusinessType.CAR_RENTAL;
  }
}
