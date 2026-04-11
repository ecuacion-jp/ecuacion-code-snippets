package jp.ecuacion.codesnippets.validation.stringwhen;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
  }

  public static void 基本的な使い方() {
    OrderInfoWithMessage order = new OrderInfoWithMessage(null, "HOME_DELIVERY");

    Set<ConstraintViolation<OrderInfoWithMessage>> set = validator.validate(order);
    for (ConstraintViolation<?> v : set) {
      System.out.println(v.getMessage());
    }
  }
}
