package jp.ecuacion.codesnippets.validation.patterwithdescription;

import jp.ecuacion.lib.validation.constraints.PatternWithDescription;

public record PersonWithoutMessage(@PatternWithDescription(regexp = "^[A-Z][a-z]*$",
    descriptionId = "description.firstName") String firstName, int age) {

}
