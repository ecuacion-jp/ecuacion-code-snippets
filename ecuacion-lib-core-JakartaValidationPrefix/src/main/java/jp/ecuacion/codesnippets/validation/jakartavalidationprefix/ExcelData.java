package jp.ecuacion.codesnippets.validation.jakartavalidationprefix;

import jakarta.validation.constraints.NotNull;

public record ExcelData(@NotNull String name, String mailAddress) {

}
