package jp.ecuacion.codesnippets.validation.lessthan;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.LocalDate;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
    ExceptionUtilによるメッセージ出力();
    propertyPathの指定();
  }

  public static void 基本的な使い方() {
    ProjectWithMessage project =
        new ProjectWithMessage("some project", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1));

    Set<ConstraintViolation<ProjectWithMessage>> set = validator.validate(project);
    for (ConstraintViolation<ProjectWithMessage> v : set) {
      System.out.println(v.getMessage());
    }
  }

  private static void ExceptionUtilによるメッセージ出力() {
    Project project = new Project("some project",
        LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1));

    Set<ConstraintViolation<Project>> set = validator.validate(project);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }

  public static void propertyPathの指定() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    Set<ConstraintViolation<Family>> setPropertyPath = validator.validate(family);
    for (ConstraintViolation<Family> v : setPropertyPath) {
      System.out.println(v.getMessage());
    }
  }
}
