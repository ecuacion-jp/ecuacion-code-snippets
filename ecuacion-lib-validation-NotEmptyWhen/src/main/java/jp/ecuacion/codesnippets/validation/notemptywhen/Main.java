package jp.ecuacion.codesnippets.validation.notemptywhen;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
  }

  public static void 基本的な使い方() {
    AccountWithMessage account = new AccountWithMessage("John", true, null);

    var set = validator.validate(account);
    for (ConstraintViolation<?> v : set) {
      System.out.println(v.getMessage());
    }
  }
}
