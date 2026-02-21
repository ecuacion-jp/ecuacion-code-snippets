package jp.ecuacion.codesnippets.validation.anynotempty;

import jp.ecuacion.lib.validation.constraints.AnyNotEmpty;

@AnyNotEmpty(propertyPath = {"firstName", "middleName", "lastName"},
    message = "3つの名前のうち少なくとも一つは入力してください")
public record Name(String firstName, String middleName, String lastName) {

}
