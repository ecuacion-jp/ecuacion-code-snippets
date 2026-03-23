package jp.ecuacion.codesnippets.validation.jakartavalidationlist;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record Account(String name, @NotNull List<@NotNull String> mailAddresses) {

}
