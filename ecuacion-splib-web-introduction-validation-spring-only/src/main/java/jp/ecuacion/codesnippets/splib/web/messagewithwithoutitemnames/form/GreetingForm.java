package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form;

import jakarta.validation.constraints.NotEmpty;

public class GreetingForm {

    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
