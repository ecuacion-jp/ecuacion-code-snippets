package jp.ecuacion.codesnippets.validation.jakartavalidationitemnamepattern;

import jakarta.validation.constraints.NotNull;

public record Account(@NotNull String name, String mailAddress) {

}
