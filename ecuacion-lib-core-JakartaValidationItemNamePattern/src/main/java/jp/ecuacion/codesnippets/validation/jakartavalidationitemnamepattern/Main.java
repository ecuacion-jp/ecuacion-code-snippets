package jp.ecuacion.codesnippets.validation.jakartavalidationitemnamepattern;

import jakarta.validation.ConstraintViolationException;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.ValidationUtil;

public class Main {

  public static void main(String... args) {
    基本的な使い方();
  }

  public static void 基本的な使い方() {
    try {
      Account account = new Account(null, null);

      ValidationUtil.validateThenThrow(account,
          ValidationUtil.messageParameters().isMessageWithItemName(true));

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }
}
