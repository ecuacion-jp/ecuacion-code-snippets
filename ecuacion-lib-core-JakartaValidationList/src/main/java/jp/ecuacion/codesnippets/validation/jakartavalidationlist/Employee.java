package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import jakarta.validation.Valid;
import java.util.List;

public record Employee(String name,  List<@Valid Laptop> laptopList) {

}
