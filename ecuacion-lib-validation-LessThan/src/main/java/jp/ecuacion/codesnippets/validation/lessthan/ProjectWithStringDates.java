package jp.ecuacion.codesnippets.validation.lessthan;

import jp.ecuacion.lib.validation.constraints.LessThan;
import jp.ecuacion.lib.validation.constraints.enums.TypeConversionFromString;

@LessThan(propertyPath = "startDate", baselinePropertyPath = "endDate",
    typeConversionFromString = TypeConversionFromString.DATE, typeConversionDateFormat = "yyyy/MM/dd")
public record ProjectWithStringDates(String projectName, String startDate, String endDate) {

}
