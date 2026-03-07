package jp.ecuacion.codesnippets.validation.lessthan;

import java.time.LocalDate;
import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "startDate", baselinePropertyPath = "endDate",
    message = "{startDateIsPastThanEndDate.message}")
public record ProjectWithMessageKey(String projectName, LocalDate startDate, LocalDate endDate) {

}
