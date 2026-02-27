package jp.ecuacion.codesnippets.validation.patterwithdescription;

import jp.ecuacion.lib.validation.constraints.PatternWithDescription;

public record PersonWithJapaneseDescription(@PatternWithDescription(regexp = "^[A-Z][a-z]*$",
    description = "一文字目は大文字、二文字目以降は小文字") String firstName, int age) {

}
