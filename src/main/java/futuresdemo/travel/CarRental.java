package futuresdemo.travel;

public class CarRental extends AbstractBookingItem {
  public CarRental(long waitTimeInSeconds) {
    super(waitTimeInSeconds);
  }

  public BusinessType getBusinessType() {
    return BusinessType.CAR_RENTAL;
  }
}
