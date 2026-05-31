package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.controller;

import jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form.GreetingForm;
import jp.ecuacion.splib.web.util.SplibValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @Autowired
    private SplibValidationHelper validationHelper;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("greetingForm", new GreetingForm());
        return "index";
    }

    @PostMapping("/greeting")
    public String greeting(GreetingForm form, Model model) {
        validationHelper.validate(form, "index");
        model.addAttribute("name", form.getName());
        return "greeting";
    }
}
