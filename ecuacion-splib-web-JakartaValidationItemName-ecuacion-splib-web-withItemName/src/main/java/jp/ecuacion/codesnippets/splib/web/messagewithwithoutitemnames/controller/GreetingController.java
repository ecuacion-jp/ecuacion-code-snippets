package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.controller;

import jakarta.validation.Valid;
import jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form.GreetingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("greetingForm", new GreetingForm());
        return "index";
    }

    @PostMapping("/greeting")
    public String greeting(@Valid @ModelAttribute GreetingForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        model.addAttribute("name", form.getName());
        return "greeting";
    }
}
