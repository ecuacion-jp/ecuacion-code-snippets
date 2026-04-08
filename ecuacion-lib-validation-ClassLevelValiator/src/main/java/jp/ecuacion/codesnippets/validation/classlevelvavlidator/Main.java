package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    propertyPathの指定();
    ValidationMessages_propertiesの使用();
    ExceptionUtilを使用したメッセージ出力();
    項目名の表示();
  }

  public static void propertyPathの指定() {
    var family = new FamilyWithMessage(new Person("John", 25), new Person("Paul", 27));

    var constraintViolations = validator.validate(family);
    for (var cv : constraintViolations) {
      System.out.println(cv.getMessage());
    }
  }

  private static void ValidationMessages_propertiesの使用() {
    var project = new FamilyWithMessageKey(new Person("John", 25), new Person("Paul", 27));

    for (ConstraintViolation<?> v : validator.validate(project)) {
      System.out.println(v.getMessage());
    }
  }

  private static void ExceptionUtilを使用したメッセージ出力() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    var set = validator.validate(family);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void 項目名の表示() {
    var family = new Family(new Person("John", 25), new Person("Paul", 27));

    var constraintViolations = validator.validate(family);
    for (String message : ExceptionUtil.getMessageList(constraintViolations, true)) {
      System.out.println(message);
    }
  }
}
