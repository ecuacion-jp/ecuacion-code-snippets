package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.controller;

import jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form.ContactForm;
import jp.ecuacion.splib.web.util.SplibValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private SplibValidationHelper validationHelper;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "index";
    }

    @PostMapping("/contact")
    public String contact(ContactForm form, Model model) {
        validationHelper.validate(form, "index");
        model.addAttribute("name", form.getName());
        model.addAttribute("email", form.getEmail());
        return "result";
    }
}
