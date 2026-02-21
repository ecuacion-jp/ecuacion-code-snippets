package jp.ecuacion.codesnippets.validation.anynotempty;

import jp.ecuacion.lib.validation.constraints.AnyNotEmpty;

@AnyNotEmpty(propertyPath = {"firstName", "middleName", "lastName"})
public record NameWithoutMessage(String firstName, String middleName, String lastName) {

}
