package jp.ecuacion.codesnippets.validation.lessthan;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.LocalDate;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
    Stringの比較();
  }

  public static void 基本的な使い方() {
    LocalDate pastDate = LocalDate.of(2026, 1, 1);
    var project = new ProjectWithMessage("some project", pastDate, pastDate);

    var constraintViolations = validator.validate(project);
    for (var cv : constraintViolations) {
      System.out.println(cv.getMessage());
    }
  }

  private static void Stringの比較() {
    var project = new ProjectWithStringDates("some project", "2026/01/01", "2025/12/31");

    for (String message : ExceptionUtil.getMessageList(validator.validate(project))) {
      System.out.println(message);
    }
  }
}
