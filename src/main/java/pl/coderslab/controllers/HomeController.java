package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {



    @GetMapping("")
    public String showAll(Model model){
        return "/home";
    }
}
