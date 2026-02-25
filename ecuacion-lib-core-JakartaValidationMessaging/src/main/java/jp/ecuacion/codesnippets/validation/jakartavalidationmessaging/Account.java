package jp.ecuacion.codesnippets.validation.jakartavalidationmessaging;

import jakarta.validation.constraints.NotNull;

public record Account(@NotNull String name, String mailAddress) {

}
