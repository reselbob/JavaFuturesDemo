package futuresdemo.trip;

public class ResultImpl implements Result {

  private final String message;

  ResultImpl(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
