package jp.ecuacion.codesnippets.validation.validchildobjectitemnamepath;

import jakarta.validation.ConstraintViolationException;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.ValidationUtil;
import jp.ecuacion.lib.core.util.ValidationUtil.MessageParameters;

public class Main {

  public static void main(String... args) {
    基本的な使い方();
  }

  public static void 基本的な使い方() {
    Employee employee = new Employee("山田太郎", new Laptop(null), new CellPhone(null));

    try {
      MessageParameters params = ValidationUtil.messageParameters()
          .isMessageWithItemName(true)
          .showsItemNamePath(true);
      ValidationUtil.validateThenThrow(employee, params);

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }
}
