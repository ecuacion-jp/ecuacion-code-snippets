package jp.ecuacion.codesnippets.validation.truewhen;

import jp.ecuacion.lib.validation.constraints.TrueWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@TrueWhen(propertyPath = "smsConsentAgreed", conditionPropertyPath = "phone",
    conditionValue = ConditionValue.PATTERN, conditionValuePatternRegexp = "^(070|080|090).*",
    conditionValuePatternDescription = "携帯電話番号")
public record UserContact(String phone, boolean smsConsentAgreed) {

}
