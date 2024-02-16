package futuresdemo.travel;

import java.util.UUID;

public class ConfirmationImpl implements Confirmation {

  private final String message;
  private final BusinessType businessType;
  private final UUID id = UUID.randomUUID();

  ConfirmationImpl(String message, BusinessType businessType) {
    this.message = message;
    this.businessType = businessType;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  public String getBusinessType() {
    return this.businessType.toString();
  }

  @Override
  public UUID getId() {
    return this.id;
  }
}
