package jp.ecuacion.codesnippets.validation.notemptywhen;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
    ExceptionUtilを使用したメッセージ出力();
  }

  public static void 基本的な使い方() {
    AccountWithMessage account = new AccountWithMessage("John", false, null);

    Set<ConstraintViolation<AccountWithMessage>> set = validator.validate(account);
    for (ConstraintViolation<?> v : set) {
      System.out.println(v.getMessage());
    }
  }

  private static void ExceptionUtilを使用したメッセージ出力() {
    Account account = new Account("John", false, null);

    Set<ConstraintViolation<Account>> set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
