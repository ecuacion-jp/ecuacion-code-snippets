package jp.ecuacion.codesnippets.validation.jakartavalidationmessaging;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.exception.ConstraintViolationExceptionWithParameters;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.PropertiesFileUtil.Arg;
import jp.ecuacion.lib.core.violation.Violations;
import jp.ecuacion.lib.core.violation.Violations.MessageParameters;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    ExceptionUtilの基本的な使い方();
    メッセージに項目名を含めたい();
    メッセージの項目名表示有無を選択したい_システムデフォルト設定();

    ValidationUtilの基本的な使い方();
    メッセージの項目名表示有無を選択したい_個別validation時();
    メッセージの前後に追加文言を付加したい();
    Argを使用();
  }

  public static void ExceptionUtilの基本的な使い方() {
    Account account = new Account(null, null);

    Set<ConstraintViolation<Account>> set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void メッセージに項目名を含めたい() {
    Account account = new Account(null, null);

    Set<ConstraintViolation<Account>> set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  public static void メッセージの項目名表示有無を選択したい_システムデフォルト設定() {
    Account account = new Account(null, null);

    Set<ConstraintViolation<Account>> set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set, true)) {
      System.out.println(message);
    }
  }

  private static void ValidationUtilの基本的な使い方() {
    Account account = new Account(null, null);

    try {
      var constraintViolations = validator.validate(account);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationException(constraintViolations);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }

  private static void メッセージの項目名表示有無を選択したい_個別validation時() {
    Account account = new Account(null, null);
    MessageParameters params = Violations.newMessageParameters().isMessageWithItemName(true);

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

  private static void メッセージの前後に追加文言を付加したい() {
    Account account = new Account(null, null);
    MessageParameters params = Violations.newMessageParameters()
        .isMessageWithItemName(true)
        .messagePrefix("アップロードしたエクセルファイルにおいて、");

    try {
      var constraintViolations = validator.validate(account);
      if (constraintViolations.size() > 0) {
        new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }

  private static void Argを使用() {
    Account account = new Account(null, null);
    MessageParameters params = Violations.newMessageParameters()
        .isMessageWithItemName(true)
        .messagePrefix(Arg.message("ABOUT_UPLOADED_EXCEL"));

    try {
      var constraintViolations = validator.validate(account);
      if (constraintViolations.size() > 0) {
        new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }
}
