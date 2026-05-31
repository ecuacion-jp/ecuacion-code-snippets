package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import java.util.Arrays;
import java.util.List;
import jp.ecuacion.lib.core.exception.ViolationException;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;

public class Main {

//  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    validationの分割による解決();
    基本的な使い方();
    複数階層のList();
    List_String_の取り扱い();
    List自体へのvalidationの取り扱い();
  }

  private static void validationの分割による解決() {
    EmployeeWithoutValid employee =
        new EmployeeWithoutValid("John", List.of(new Laptop(1, null)));

    try {
      // employee の validation
      new Violations().validate(employee).throwIfAny();

      // laptop の validation
      for (int i = 0; i < employee.laptopList().size(); i++) {
        var params =
            Violations.newMessageParameters().messagePrefix((i + 1) + "番目のノートPCについて、");
        new Violations().validate(employee.laptopList().get(i)).messageParameters(params).throwIfAny();
      }

    } catch (ViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  public static void 基本的な使い方() {
    Employee employee = new Employee("John", List.of(new Laptop(1, null)));

    try {
      var params = Violations.newMessageParameters().showsItemNamePath(true);
      new Violations().validate(employee).messageParameters(params).throwIfAny();

    } catch (ViolationException ex) {
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
      var params = Violations.newMessageParameters().showsItemNamePath(true);
      new Violations().validate(dept).messageParameters(params).throwIfAny();

    } catch (ViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void List_String_の取り扱い() {
    List<String> mailAddressList = Arrays.asList("test@test.com", null);
    Account account = new Account("John", mailAddressList);

    try {
      var params = Violations.newMessageParameters().showsItemNamePath(true);
      new Violations().validate(account).messageParameters(params).throwIfAny();

    } catch (ViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void List自体へのvalidationの取り扱い() {
    Account account = new Account("John", null);

    try {
      var params = Violations.newMessageParameters().showsItemNamePath(true);
      new Violations().validate(account).messageParameters(params).throwIfAny();

    } catch (ViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }
}
