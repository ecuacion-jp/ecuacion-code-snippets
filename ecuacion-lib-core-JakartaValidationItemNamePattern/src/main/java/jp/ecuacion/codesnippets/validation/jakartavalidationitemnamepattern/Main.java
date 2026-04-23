package jp.ecuacion.codesnippets.validation.jakartavalidationitemnamepattern;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jp.ecuacion.lib.core.exception.ConstraintViolationExceptionWithParameters;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
  }

  public static void 基本的な使い方() {
    Account account = new Account(null, null);
    var params = Violations.newMessageParameters().isMessageWithItemName(true);

    try {
      var constraintViolations = validator.validate(account);
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
