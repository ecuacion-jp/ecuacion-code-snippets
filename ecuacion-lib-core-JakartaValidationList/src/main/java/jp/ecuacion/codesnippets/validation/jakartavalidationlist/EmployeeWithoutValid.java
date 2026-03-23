package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import java.util.List;

public record EmployeeWithoutValid(String name, List<Laptop> laptopList) {
  
}
