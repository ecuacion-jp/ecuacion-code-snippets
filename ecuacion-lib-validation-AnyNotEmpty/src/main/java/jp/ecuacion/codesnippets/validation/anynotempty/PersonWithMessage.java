package jp.ecuacion.codesnippets.validation.anynotempty;

import jp.ecuacion.lib.validation.constraints.AnyNotEmpty;

@AnyNotEmpty(propertyPath = {"homePhoneNumber", "mobilePhoneNumber"}, 
      message = "自宅か携帯、いずれかの電話番号は入力必須です")
public record PersonWithMessage(String name, String homePhoneNumber, String mobilePhoneNumber) {

}
