package jp.ecuacion.codesnippets.validation.jakartavalidationitemname;

import jakarta.validation.constraints.NotNull;

public record AccountWithMessage(
    @NotNull(message="{0}は必須だ！") String name,
    String mailAddress) {

}
