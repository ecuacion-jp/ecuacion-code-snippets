package jp.ecuacion.codesnippets.validation.truewhen;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
    conditionValuePatternDescriptionの使用();
  }

  public static void 基本的な使い方() {
    UserContactWithMessage info = new UserContactWithMessage("090-1234-5678", false);

    var set = validator.validate(info);
    for (ConstraintViolation<?> v : set) {
      System.out.println(v.getMessage());
    }
  }

  public static void conditionValuePatternDescriptionの使用() {
    UserContact info = new UserContact("090-1234-5678", false);

    Set<ConstraintViolation<UserContact>> set = validator.validate(info);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
