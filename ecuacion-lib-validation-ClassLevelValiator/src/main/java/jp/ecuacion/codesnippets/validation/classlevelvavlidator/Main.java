package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.LocalDate;
import jp.ecuacion.lib.core.jakartavalidation.constraintvalidator.CreateMultipleConstraintViolationsConstraintValidatorFactory;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.ValidationUtil;
import jp.ecuacion.lib.core.util.ValidationUtil.MessageParameters;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  private static Validator multipleValidator = Validation.byDefaultProvider().configure()
      .constraintValidatorFactory(
          new CreateMultipleConstraintViolationsConstraintValidatorFactory())
      .buildValidatorFactory().getValidator();

  public static void main(String... args) {
    ValidationMessages_propertiesの使用();
    ExceptionUtilを使用したメッセージ出力();
    項目名の表示();
    propertyPathの指定_階層のあるpropertyPath();
    propertyPathの指定_ExceptionUtilによるメッセージ出力();
    propertyPathの指定_itemNamePathの表示();
    propertyPathの指定_項目名の表示();
    getPropertyPathでフィールドを指定する方法();
  }

  private static void ValidationMessages_propertiesの使用() {
    LocalDate date = LocalDate.of(2026, 1, 1);
    var project = new ProjectWithMessageKey("some project", date, date);

    for (ConstraintViolation<?> v : validator.validate(project)) {
      System.out.println(v.getMessage());
    }
  }

  private static void ExceptionUtilを使用したメッセージ出力() {
    LocalDate date = LocalDate.of(2026, 1, 1);
    var project = new Project("some project", date, date);

    var set = validator.validate(project);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void 項目名の表示() {
    LocalDate date = LocalDate.of(2026, 1, 1);
    var project = new Project("some project", date, date);

    var constraintViolations = validator.validate(project);
    for (String message : ExceptionUtil.getMessageList(constraintViolations, true)) {
      System.out.println(message);
    }
  }

  public static void propertyPathの指定_階層のあるpropertyPath() {
    var family = new FamilyWithMessage(new Person("John", 25), new Person("Paul", 27));

    var constraintViolations = validator.validate(family);
    for (var cv : constraintViolations) {
      System.out.println(cv.getMessage());
    }
  }

  private static void propertyPathの指定_ExceptionUtilによるメッセージ出力() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    var set = validator.validate(family);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  private static void propertyPathの指定_itemNamePathの表示() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    try {
      MessageParameters params = ValidationUtil.messageParameters().showsItemNamePath(true);
      ValidationUtil.validateThenThrow(family, params);

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }

  private static void propertyPathの指定_項目名の表示() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    try {
      MessageParameters params =
          ValidationUtil.messageParameters().isMessageWithItemName(true).showsItemNamePath(true);
      ValidationUtil.validateThenThrow(family, params);
    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex, false)) {
        System.out.println(message);
      }
    }
  }

  private static void getPropertyPathでフィールドを指定する方法() {
    var project = new FamilyWithMessage(new Person("John", 25), new Person("Paul", 27));

    for (ConstraintViolation<?> v : multipleValidator.validate(project)) {
      System.out.println(v.getMessage() + "(propertyPath: " + v.getPropertyPath() + ")");
    }
  }
}
