package jp.ecuacion.codesnippets.validation.lessthan;

import java.time.LocalDate;
import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "startDate", basisPropertyPath = "endDate")
public record Project(String projectName, LocalDate startDate, LocalDate endDate) {

}
