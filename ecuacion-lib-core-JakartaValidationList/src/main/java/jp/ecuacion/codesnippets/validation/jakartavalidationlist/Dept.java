package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import jakarta.validation.Valid;
import java.util.List;

public record Dept(String name, List<@Valid Employee> employeeList) {

}
