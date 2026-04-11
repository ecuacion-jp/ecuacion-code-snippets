package jp.ecuacion.codesnippets.validation.classlevelvalidatorpropertypath;

import java.time.LocalDate;
import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "startDate", baselinePropertyPath = "endDate")
public record Project(String projectName, LocalDate startDate, LocalDate endDate) {

}
