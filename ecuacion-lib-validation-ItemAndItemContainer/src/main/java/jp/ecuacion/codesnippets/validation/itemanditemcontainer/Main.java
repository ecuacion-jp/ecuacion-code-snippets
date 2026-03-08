package jp.ecuacion.codesnippets.validation.itemanditemcontainer;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {
  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String[] args) {
    itemNameKey();
    ItemNameKeyClass();
  }

  private static void itemNameKey() {
    Employee person = new Employee(null, null);

    Set<ConstraintViolation<Employee>> set = validator.validate(person);
    for (String message : ExceptionUtil.getMessageList(set, true)) {
      System.out.println(message);
    }
  }

  private static void ItemNameKeyClass() {
    EmployeeDto person = new EmployeeDto(null, null);

    Set<ConstraintViolation<EmployeeDto>> set = validator.validate(person);
    for (String message : ExceptionUtil.getMessageList(set, true)) {
      System.out.println(message);
    }
  }
}
