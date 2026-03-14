package jp.ecuacion.codesnippets.validation.jakartavalidationitemname;

import jakarta.validation.constraints.NotNull;

public record Account(@NotNull String name, String mailAddress) {

}
