package jp.ecuacion.codesnippets.validation.anynotempty;

import jp.ecuacion.lib.validation.constraints.AnyNotEmpty;

@AnyNotEmpty(propertyPath = {"homePhoneNumber", "mobilePhoneNumber"})
public record Person(String name, String homePhoneNumber, String mobilePhoneNumber) {

}
