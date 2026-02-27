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
    ExceptionUtilを使用したメッセージ出力();
    ValidationMessages_propertiesの使用();
  }

  public static void 基本的な使い方() {
    ProjectWithMessage project =
        new ProjectWithMessage("some project", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1));

    Set<ConstraintViolation<ProjectWithMessage>> set = validator.validate(project);
    for (ConstraintViolation<ProjectWithMessage> v : set) {
      System.out.println(v.getMessage());
    }
  }

  private static void ValidationMessages_propertiesの使用() {
    // TODO Auto-generated method stub
    
  }

  private static void ExceptionUtilを使用したメッセージ出力() {
    Project project = new Project("some project",
        LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1));

    Set<ConstraintViolation<Project>> set = validator.validate(project);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
