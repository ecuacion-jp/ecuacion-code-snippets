package jp.ecuacion.codesnippets.validation.anynotempty;

import jp.ecuacion.lib.validation.constraints.AnyNotEmpty;

@AnyNotEmpty(propertyPath = {"homePhoneNumber", "mobilePhoneNumber"}, 
      message = "{eitherPhoneNumberRequired.message}")
public record PersonWithMessageKey(String name, String homePhoneNumber, String mobilePhoneNumber) {

}
