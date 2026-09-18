package jp.ecuacion.codesnippets.validation.truewhen;

import jp.ecuacion.lib.validation.constraints.TrueWhen;

@TrueWhen(propertyPath = "smsConsentAgreed", conditionPropertyPath = "phone",
    conditionValuePatternRegexp = "^(070|080|090).*",
    conditionValuePatternDescription = "携帯電話番号")
public record UserContact(String phone, boolean smsConsentAgreed) {

}
