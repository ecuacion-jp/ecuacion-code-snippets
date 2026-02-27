package jp.ecuacion.codesnippets.validation.patterwithdescription;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {
  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String[] args) {
    基本的な使い方();
    ExceptionUtilを使用したメッセージ出力();
    descriptionのlocalize();


  }

  private static void 基本的な使い方() {
    PersonWithJapaneseDescription person = new PersonWithJapaneseDescription("john", 30);

    Set<ConstraintViolation<PersonWithJapaneseDescription>> set = validator.validate(person);
    for (ConstraintViolation<?> cv : set) {
      System.out.println(cv.getMessage());
    }
  }

  private static void ExceptionUtilを使用したメッセージ出力() {
    PersonWithJapaneseDescription person = new PersonWithJapaneseDescription("john", 30);

    Set<ConstraintViolation<PersonWithJapaneseDescription>> set = validator.validate(person);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void descriptionのlocalize() {
    Person person = new Person("john", 30);

    Set<ConstraintViolation<Person>> set = validator.validate(person);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
