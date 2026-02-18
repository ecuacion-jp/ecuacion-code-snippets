package jp.ecuacion.codesnippets.validation.lessthan;

import java.time.LocalDate;
import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "startDate", basisPropertyPath = "endDate", message = "開始日は終了日より過去にしてください。")
public record Project(String projectName, LocalDate startDate, LocalDate endDate) {

}