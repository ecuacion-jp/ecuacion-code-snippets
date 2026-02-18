package jp.ecuacion.codesnippets.validation.patterwithdescription;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {
  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String[] args) {
    基礎();
    localized();
    

    // for (String message : ExceptionUtil.getMessageList(set)) {
    // System.out.println(message);
    // }
  }

  private static void 基礎() {
    Person person = new Person("john", 30);

    Set<ConstraintViolation<Person>> set = validator.validate(person);
    for (ConstraintViolation<Person> cv : set) {
      System.out.println(cv.getMessage());
    }
  }

  private static void localized() {
    PersonLocalized person = new PersonLocalized("john", 30);

    Set<ConstraintViolation<PersonLocalized>> set = validator.validate(person);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
