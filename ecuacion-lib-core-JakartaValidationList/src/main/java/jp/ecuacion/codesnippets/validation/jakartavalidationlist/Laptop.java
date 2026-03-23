package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import jakarta.validation.constraints.NotNull;

public record Laptop(int id, @NotNull String model) {

}
