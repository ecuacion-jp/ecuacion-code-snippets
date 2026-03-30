package jp.ecuacion.codesnippets.validation.jakartavalidationitemname;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
//    基本的な使い方();
    ValidationMessages_propertiesの使用();
  }

  public static void 基本的な使い方() {
    var account = new AccountWithMessage(null, null);

    var set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void ValidationMessages_propertiesの使用() {
    var account = new Account(null, null);

    var set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
