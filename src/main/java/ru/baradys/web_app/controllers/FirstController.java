package ru.baradys.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name") String name,
                            Model model){
    model.addAttribute("message", "Пользователь " + name + " есть");


        return "answer/welcome";
    }

    @GetMapping("/notAllowed")
    public String notAllowed(@RequestParam("name") String name, Model model){
        model.addAttribute("message", "Пользователя " + name + " нет");
        return "answer/notAllowed";
    }
}
