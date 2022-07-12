package ru.baradys.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.baradys.web_app.models.Person;

@Controller
@RequestMapping()
public class PeopleController {

    @GetMapping()
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "user/auth";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        if(person.getName().equals(System.getProperty("user.name")))
            return "redirect:/welcome?name=" + person.getName();

        return "redirect:/notAllowed?name=" + person.getName();
    }
}
