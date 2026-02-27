package jp.ecuacion.codesnippets.validation.patterwithdescription;

import jp.ecuacion.lib.validation.constraints.PatternWithDescription;

public record Person(@PatternWithDescription(regexp = "^[A-Z][a-z]*$",
    description = "description.firstName") String firstName, int age) {

}
