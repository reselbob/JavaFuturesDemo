package futuresdemo.commerce;

import futuresdemo.utils.DateConverter;

public abstract class AbstractCommerceActivity {

  // Get the class name of this class
  public String getClassName() {
    return this.getClass().getSimpleName();
  }

  public AbstractCommerceActivity() {
    String str =
        String.format(
            "%s started at %s",
            this.getClassName(),
            DateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
    System.out.println(str);
  }
}
