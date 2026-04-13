package jp.ecuacion.codesnippets.validation.validchildobjectitemnamepath;

import jakarta.validation.Valid;

public record Employee(String name, @Valid Laptop laptop, @Valid CellPhone cellPhone) {

}
