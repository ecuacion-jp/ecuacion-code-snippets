package jp.ecuacion.codesnippets.validation.jakartavalidationexceptionutil;

import jakarta.validation.constraints.NotNull;

public record Account(@NotNull String name) {

}
