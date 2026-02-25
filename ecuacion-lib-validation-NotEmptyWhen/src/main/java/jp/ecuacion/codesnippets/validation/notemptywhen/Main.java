package jp.ecuacion.codesnippets.validation.notemptywhen;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    ApplicationForParticipation application = new ApplicationForParticipation(null, false, null);

    Set<ConstraintViolation<ApplicationForParticipation>> set = validator.validate(application);
    for (ConstraintViolation<?> v : set) {
      System.out.println(v.getMessage());
    }

    基礎();
    ExceptionUtilによるメッセージ出力();
  }

  public static void 基礎() {}

  private static void ExceptionUtilによるメッセージ出力() {}
}
