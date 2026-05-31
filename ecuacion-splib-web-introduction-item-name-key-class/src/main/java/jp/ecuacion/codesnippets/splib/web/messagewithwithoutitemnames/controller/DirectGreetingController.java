package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.controller;

import jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form.DirectGreetingForm;
import jp.ecuacion.splib.web.util.SplibValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/direct")
public class DirectGreetingController {

    @Autowired
    private SplibValidationHelper validationHelper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("greetingForm", new DirectGreetingForm());
        return "direct/index";
    }

    @PostMapping("/greeting")
    public String greeting(DirectGreetingForm form, Model model) {
        validationHelper.validate(form, "direct/index");
        model.addAttribute("name", form.getName());
        return "greeting";
    }
}
