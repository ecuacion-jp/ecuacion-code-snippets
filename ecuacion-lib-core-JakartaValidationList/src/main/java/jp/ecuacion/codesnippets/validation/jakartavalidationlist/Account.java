package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import java.util.List;

public record Account(String name, List<String> mailAddresses) {

}
