package jp.ecuacion.codesnippets.validation.validchildobjectitemnamepath;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jp.ecuacion.lib.core.exception.ConstraintViolationExceptionWithParameters;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;
import jp.ecuacion.lib.core.violation.Violations.MessageParameters;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
  }

  public static void 基本的な使い方() {
    Employee employee = new Employee("山田太郎", new Laptop(null), new CellPhone(null));
    MessageParameters params = Violations.newMessageParameters()
        .isMessageWithItemName(true)
        .showsItemNamePath(true);

    try {
      var constraintViolations = validator.validate(employee);
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
