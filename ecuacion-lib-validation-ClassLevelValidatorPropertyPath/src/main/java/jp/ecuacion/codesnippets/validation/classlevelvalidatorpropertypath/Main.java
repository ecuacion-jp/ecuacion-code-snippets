package jp.ecuacion.codesnippets.validation.classlevelvalidatorpropertypath;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.LocalDate;
import jp.ecuacion.lib.core.jakartavalidation.constraintvalidator.CreateMultipleConstraintViolationsConstraintValidatorFactory;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
  private static Validator multipleValidator = Validation.byDefaultProvider().configure()
      .constraintValidatorFactory(
          new CreateMultipleConstraintViolationsConstraintValidatorFactory())
      .buildValidatorFactory().getValidator();

  public static void main(String... args) {
    デフォルトの動作();
    標準のpropertyPathフィールドを使用する方法();
  }

  public static void デフォルトの動作() {
    LocalDate date = LocalDate.of(2026, 1, 1);
    var project = new ProjectWithMessage("some project", date, date);

    var set = validator.validate(project);
    for (ConstraintViolation<?> cv : set) {
      System.out.println(cv.getMessage() + " （propertyPath : " + cv.getPropertyPath() + "）");
    }
  }

  public static void 標準のpropertyPathフィールドを使用する方法() {
    LocalDate date = LocalDate.of(2026, 1, 1);
    var project = new ProjectWithMessage("some project", date, date);

    var set = multipleValidator.validate(project);
    for (ConstraintViolation<?> cv : set) {
      System.out.println(cv.getMessage() + " （propertyPath : " + cv.getPropertyPath() + "）");
    }
  }
}
