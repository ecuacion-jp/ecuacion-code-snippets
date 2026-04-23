package jp.ecuacion.codesnippets.validation.jakartavalidationitemnamekey;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jp.ecuacion.lib.core.exception.ConstraintViolationExceptionWithParameters;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    itemNameKeyの使用_ドットなし();
    itemNameKeyの使用_ドットあり();
    ItemNameKeyClassの使用();
  }

  public static void itemNameKeyの使用_ドットなし() {
    OrderForm form = new OrderForm(null, null);
    System.out.println("getItem: " + form.getItem("productCode").getItemNameKey(form));

    try {
      var params = Violations.newMessageParameters().isMessageWithItemName(true);
      var constraintViolations = validator.validate(form);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }

  public static void itemNameKeyの使用_ドットあり() {
    OrderFormWithDot form = new OrderFormWithDot(null, null);
    System.out.println("getItem: " + form.getItem("productCode").getItemNameKey(form));

    try {
      var params = Violations.newMessageParameters().isMessageWithItemName(true);
      var constraintViolations = validator.validate(form);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }

  public static void ItemNameKeyClassの使用() {
    OrderFormWithAnnotation form = new OrderFormWithAnnotation(null, null);
    System.out.println("getItem: " + form.getItem("productCode").getItemNameKey(form));

    try {
      var params = Violations.newMessageParameters().isMessageWithItemName(true);
      var constraintViolations = validator.validate(form);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }
}
