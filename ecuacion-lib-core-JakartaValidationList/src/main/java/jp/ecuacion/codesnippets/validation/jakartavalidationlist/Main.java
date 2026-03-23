package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import jakarta.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.ValidationUtil;
import jp.ecuacion.lib.core.util.ValidationUtil.MessageParameters;

public class Main {

  public static void main(String... args) {
    validationの分割による解決();
    基本的な使い方();
    複数階層のList();
    List_String_の取り扱い();
    List自体へのvalidationの取り扱い();
  }

  private static void validationの分割による解決() {
    try {
      EmployeeWithoutValid employee =
          new EmployeeWithoutValid("John", List.of(new Laptop(1, null)));

      // employee の validation
      ValidationUtil.validateThenThrow(employee);

      // laptop の validation
      for (int i = 0; i < employee.laptopList().size(); i++) {
        MessageParameters params =
            ValidationUtil.messageParameters().messagePrefix((i + 1) + "番目のノートPCについて、");
        ValidationUtil.validateThenThrow(employee.laptopList().get(i), params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  public static void 基本的な使い方() {
    Employee employee = new Employee("John", List.of(new Laptop(1, null)));

    try {
      MessageParameters params = ValidationUtil.messageParameters().showsItemNamePath(true);
      ValidationUtil.validateThenThrow(employee, params);

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void 複数階層のList() {
    List<Laptop> laptopList = List.of(new Laptop(1, null));
    Dept dept = new Dept("Sales",
        List.of(new Employee("John", List.of()), new Employee("Paul", laptopList)));

    try {
      MessageParameters params = ValidationUtil.messageParameters().showsItemNamePath(true);
      ValidationUtil.validateThenThrow(dept, params);

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void List_String_の取り扱い() {
    List<String> mailAddressList = Arrays.asList("test@test.com", null);
    Account account = new Account("John", mailAddressList);

    try {
      MessageParameters params = ValidationUtil.messageParameters().showsItemNamePath(true);
      ValidationUtil.validateThenThrow(account, params);

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void List自体へのvalidationの取り扱い() {
    Account account = new Account("John", null);
    try {
      MessageParameters params = ValidationUtil.messageParameters().showsItemNamePath(true);
      ValidationUtil.validateThenThrow(account, params);

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }
}
