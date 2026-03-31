package jp.ecuacion.codesnippets.validation.jakartavalidationexceptionutil;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Locale;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String[] args) {
    基本的な使い方();
  }

  private static void 基本的な使い方() {
    try {
      // 以下、service層のイメージ。ここではlocale不要
      Set<ConstraintViolation<Account>> violations = validator.validate(new Account(null));
      if (violations.size() > 0) {
        throw new ConstraintViolationException(violations);
      }

    } catch (ConstraintViolationException ex) {
      // 以下、exceptionHandler内のイメージ。ここでlocaleを使用
      for (String message : ExceptionUtil.getMessageList(ex, Locale.JAPANESE)) {
        System.out.println(message);
      }
    }
  }
}
