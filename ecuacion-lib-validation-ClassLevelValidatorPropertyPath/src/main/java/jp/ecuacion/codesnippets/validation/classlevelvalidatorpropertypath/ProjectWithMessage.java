package jp.ecuacion.codesnippets.validation.classlevelvalidatorpropertypath;

import java.time.LocalDate;
import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "startDate", baselinePropertyPath = "endDate",
    message = "開始日は終了日より過去にしてください。")
public record ProjectWithMessage(String projectName, LocalDate startDate, LocalDate endDate) {

}
