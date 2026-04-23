package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Arrays;
import java.util.List;
import jp.ecuacion.lib.core.exception.ConstraintViolationExceptionWithParameters;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;
import jp.ecuacion.lib.core.violation.Violations.MessageParameters;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

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
      var constraintViolations = validator.validate(employee);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationException(constraintViolations);
      }

      // laptop の validation
      for (int i = 0; i < employee.laptopList().size(); i++) {
        MessageParameters params =
            Violations.newMessageParameters().messagePrefix((i + 1) + "番目のノートPCについて、");
        new ConstraintViolationExceptionWithParameters(
            validator.validate(employee.laptopList().get(i)), params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  public static void 基本的な使い方() {
    Employee employee = new Employee("John", List.of(new Laptop(1, null)));
    MessageParameters params = Violations.newMessageParameters().showsItemNamePath(true);

    try {
      var constraintViolations = validator.validate(employee);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

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
    MessageParameters params = Violations.newMessageParameters().showsItemNamePath(true);

    try {
      var constraintViolations = validator.validate(dept);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void List_String_の取り扱い() {
    List<String> mailAddressList = Arrays.asList("test@test.com", null);
    Account account = new Account("John", mailAddressList);
    MessageParameters params = Violations.newMessageParameters().showsItemNamePath(true);

    try {
      var constraintViolations = validator.validate(account);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }

  private static void List自体へのvalidationの取り扱い() {
    Account account = new Account("John", null);
    MessageParameters params = Violations.newMessageParameters().showsItemNamePath(true);
    
    try {
      var constraintViolations = validator.validate(account);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, true)) {
        System.out.println(message);
      }
    }
  }
}
