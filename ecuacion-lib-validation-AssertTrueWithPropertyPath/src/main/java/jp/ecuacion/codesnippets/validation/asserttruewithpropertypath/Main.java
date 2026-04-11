package jp.ecuacion.codesnippets.validation.asserttruewithpropertypath;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Arrays;
import jp.ecuacion.lib.core.jakartavalidation.constraintvalidator.CreateMultipleConstraintViolationsConstraintValidatorFactory;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {
  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
  private static Validator multipleValidator = Validation.byDefaultProvider().configure()
      .constraintValidatorFactory(
          new CreateMultipleConstraintViolationsConstraintValidatorFactory())
      .buildValidatorFactory().getValidator();

  public static void main(String[] args) {
    基本的な使い方();
    項目名の表示();
    標準のpropertyPathフィールドを使用する方法();
    prefixを除外する方法_ReturnTrue();
  }

  private static void 基本的な使い方() {
    PilotWithMessage pilot = new PilotWithMessage("John", true, false);

    var set = validator.validate(pilot);
    for (ConstraintViolation<?> cv : set) {
      Object propertyPaths = cv.getConstraintDescriptor().getAttributes().get("propertyPath");

      System.out.println(
          cv.getMessage() + " （propertyPath : " + Arrays.toString((String[]) propertyPaths) + "）");
    }
  }

  private static void 項目名の表示() {
    Pilot pilot = new Pilot("John", true, false);

    var set = validator.validate(pilot);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void 標準のpropertyPathフィールドを使用する方法() {
    PilotWithMessage pilot = new PilotWithMessage("John", true, false);

    var set = multipleValidator.validate(pilot);
    for (ConstraintViolation<?> cv : set) {
      System.out.println(cv.getMessage() + " （propertyPath : " + cv.getPropertyPath() + "）");
    }
  }

  private static void prefixを除外する方法_ReturnTrue() {
    var pilot = new PilotWithMessageReturnTrue("John", true, false);

    var set = multipleValidator.validate(pilot);
    for (ConstraintViolation<?> cv : set) {
      System.out.println(cv.getMessage() + " （propertyPath : " + cv.getPropertyPath() + "）");
    }
  }
}
