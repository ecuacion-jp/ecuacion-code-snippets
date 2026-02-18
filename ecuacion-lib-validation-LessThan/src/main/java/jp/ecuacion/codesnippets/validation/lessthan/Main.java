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
    基礎();
    propertyPathの指定();
    ExceptionUtilによるメッセージ出力();
  }

  public static void 基礎() {
    Project project = new Project("some project", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1));
    
    Set<ConstraintViolation<Project>> set = validator.validate(project);
    for (ConstraintViolation<Project> v : set) {
      System.out.println(v.getMessage());
    }
  }
  
  public static void propertyPathの指定() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    Set<ConstraintViolation<Family>> setPropertyPath = validator.validate(family);
    for (ConstraintViolation<Family> v : setPropertyPath) {
      System.out.println(v.getMessage());
    }
  }

  private static void ExceptionUtilによるメッセージ出力() {
    FamilyWithoutMessage family = new FamilyWithoutMessage(new Person("John", 25), new Person("Paul", 27));

    Set<ConstraintViolation<FamilyWithoutMessage>> set = validator.validate(family);
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
