package jp.ecuacion.codesnippets.validation.jakartavalidationexceptionutil;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.metadata.ConstraintDescriptor;
import java.util.Locale;
import java.util.Set;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

public class Main {
  public static void main(String[] args) {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Set<ConstraintViolation<User>> violations = validator.validate(new User(null));
    for (ConstraintViolation<?> violation : violations) {
      System.out.println(getMessage(violation, Locale.ENGLISH));
    }
  }

  private static String getMessage(ConstraintViolation<?> violation, Locale locale) {
    MessageInterpolator.Context context = new MessageInterpolatorContext(violation);

    PlatformResourceBundleLocator userBundleLocator =
        new PlatformResourceBundleLocator("ValidationMessages");
    MessageInterpolator interpolator = new ResourceBundleMessageInterpolator(userBundleLocator);


    return interpolator.interpolate(violation.getMessageTemplate(), context, locale);
  }

  private static class MessageInterpolatorContext implements MessageInterpolator.Context {
    private ConstraintViolation<?> violation;

    public MessageInterpolatorContext(ConstraintViolation<?> violation) {
      this.violation = violation;
    }

    @Override
    public ConstraintDescriptor<?> getConstraintDescriptor() {
      return violation.getConstraintDescriptor();
    }

    @Override
    public Object getValidatedValue() {
      return violation.getInvalidValue();
    }

    @Override
    public <T> T unwrap(Class<T> type) {
      return null;
    }
  }
}
