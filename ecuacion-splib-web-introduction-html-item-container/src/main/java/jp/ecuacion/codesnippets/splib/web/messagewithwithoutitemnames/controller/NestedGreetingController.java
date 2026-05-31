package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.controller;

import jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form.NestedGreetingForm;
import jp.ecuacion.splib.web.util.SplibValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nested")
public class NestedGreetingController {

    @Autowired
    private SplibValidationHelper validationHelper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("greetingForm", new NestedGreetingForm());
        return "nested/index";
    }

    @PostMapping("/greeting")
    public String greeting(NestedGreetingForm form, Model model) {
        validationHelper.validate(form, "nested/index");
        model.addAttribute("name", form.getData().getName());
        return "greeting";
    }
}
