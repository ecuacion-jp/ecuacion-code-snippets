package jp.ecuacion.codesnippets.validation.asserttruewithpropertypath;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Arrays;
import java.util.Set;
import jp.ecuacion.lib.core.jakartavalidation.constraintvalidator.CreateMultipleConstraintViolationsConstraintValidatorFactory;

public class Main {
  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
  private static Validator multipleValidator = Validation.byDefaultProvider().configure()
      .constraintValidatorFactory(
          new CreateMultipleConstraintViolationsConstraintValidatorFactory())
      .buildValidatorFactory().getValidator();

  public static void main(String[] args) {
    基本的な使い方();
    標準のpropertyPathフィールドを使用する方法();
  }

  private static void 基本的な使い方() {
    Pilot pilot = new Pilot("john", true, false);

    Set<ConstraintViolation<Pilot>> set = validator.validate(pilot);
    for (ConstraintViolation<?> cv : set) {
      Object propertyPaths = cv.getConstraintDescriptor().getAttributes().get("propertyPath");
      String propertyPathCsv = Arrays.toString((String[]) propertyPaths);

      System.out.println(cv.getMessage() + " （propertyPath : " + propertyPathCsv + "）");
    }
  }

  private static void 標準のpropertyPathフィールドを使用する方法() {
    Pilot pilot = new Pilot("john", true, false);

    Set<ConstraintViolation<Pilot>> set = multipleValidator.validate(pilot);
    for (ConstraintViolation<?> cv : set) {
      System.out.println(cv.getMessage() + " （propertyPath : " + cv.getPropertyPath() + "）");
    }
  }
}
