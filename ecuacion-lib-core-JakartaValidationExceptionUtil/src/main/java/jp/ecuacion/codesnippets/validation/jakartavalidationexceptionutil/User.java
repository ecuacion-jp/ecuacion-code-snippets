package jp.ecuacion.codesnippets.validation.jakartavalidationexceptionutil;

import jakarta.validation.constraints.NotNull;

public record User(@NotNull String name) {

}
