package jp.ecuacion.codesnippets.validation.jakartavalidationmessaging;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.jakartavalidation.bean.ConstraintViolationBean;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.PropertyFileUtil.Arg;
import jp.ecuacion.lib.core.util.ValidationUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    ExceptionUtilの基本的な使い方();
    メッセージの項目名表示有無を選択したい_システムデフォルト設定();
    locale指定();

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

  public static void メッセージの項目名表示有無を選択したい_システムデフォルト設定() {
    Account account = new Account(null, null);

    Set<ConstraintViolation<Account>> set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set, true)) {
      System.out.println(message);
    }
  }

  private static void locale指定() {
    Account account = new Account(null, null);

    Set<ConstraintViolation<Account>> set = validator.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void ValidationUtilの基本的な使い方() {
    Account account = new Account(null, null);

    Set<ConstraintViolationBean<Account>> set = ValidationUtil.validate(account);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void メッセージの項目名表示有無を選択したい_個別validation時() {
    Account account = new Account(null, null);

    Set<ConstraintViolationBean<Account>> set = ValidationUtil.validate(account,
        ValidationUtil.messageParameters().isMessageWithItemNames(true));
    for (String message : ExceptionUtil.getMessageList(set, false)) {
      System.out.println(message);
    }
  }

  private static void メッセージの前後に追加文言を付加したい() {
    Account account = new Account(null, null);

    Set<ConstraintViolationBean<Account>> set = ValidationUtil.validate(account, ValidationUtil
        .messageParameters().isMessageWithItemNames(true).messagePrefix("アップロードしたエクセルファイルにおいて、"));
    for (String message : ExceptionUtil.getMessageList(set, false)) {
      System.out.println(message);
    }
  }

  private static void Argを使用() {
    Account account = new Account(null, null);

    Set<ConstraintViolationBean<Account>> set =
        ValidationUtil.validate(account, ValidationUtil.messageParameters()
            .isMessageWithItemNames(true).messagePrefix(Arg.message("ABOUT_UPLOADED_EXCEL")));
    for (String message : ExceptionUtil.getMessageList(set, false)) {
      System.out.println(message);
    }
  }
}
