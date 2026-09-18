package jp.ecuacion.codesnippets.validation.stringwhen;

import jp.ecuacion.lib.validation.constraints.StringWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValueState;

@StringWhen(propertyPath = "deliveryType", string = {"STORE_PICKUP"},
    conditionPropertyPath = "deliveryAddress", conditionValueState = ConditionValueState.EMPTY)
public record OrderInfo(String deliveryAddress, String deliveryType) {

}
