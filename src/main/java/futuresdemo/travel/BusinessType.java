package futuresdemo.travel;

public enum BusinessType {
  HOTEL,
  AIRLINE,
  CAR_RENTAL;

  // Add a method to return the business type as a string
  public String toString() {
    return this.name().toLowerCase().replace("_", " ");
  }
}
