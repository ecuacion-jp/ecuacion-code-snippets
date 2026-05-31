package jp.ecuacion.codesnippets.validation.validchildobjectitemnamepath;

import jp.ecuacion.lib.core.exception.ViolationException;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;

public class Main {

  public static void main(String... args) {
    showsItemNamePathの使い方();
  }

  public static void showsItemNamePathの使い方() {
    Employee employee = new Employee("山田太郎", new Laptop(null), new CellPhone(null));

    try {
      var params = Violations.newMessageParameters()
          .isMessageWithItemName(true)
          .showsItemNamePath(true);
      new Violations().validate(employee).messageParameters(params).throwIfAny();

    } catch (ViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }
}
