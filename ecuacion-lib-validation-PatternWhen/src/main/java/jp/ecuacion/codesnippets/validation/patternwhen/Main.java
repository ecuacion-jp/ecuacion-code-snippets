package jp.ecuacion.codesnippets.validation.patternwhen;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
    descriptionの使用();
  }

  public static void 基本的な使い方() {
    ApprovalRequestWithMessage request = new ApprovalRequestWithMessage("USER001", "USER001", "通常申請です");

    var set = validator.validate(request);
    for (ConstraintViolation<?> v : set) {
      System.out.println(v.getMessage());
    }
  }

  public static void descriptionの使用() {
    ApprovalRequest request = new ApprovalRequest("USER001", "USER001", "通常申請です");

    Set<ConstraintViolation<ApprovalRequest>> set = validator.validate(request);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
