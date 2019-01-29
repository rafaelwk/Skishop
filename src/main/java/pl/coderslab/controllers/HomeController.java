package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;

import javax.servlet.http.HttpSession;


@Controller

public class HomeController {

    @GetMapping("")
    public String showAll(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
//        model.addAttribute("user",user);
        return "/home";
    }
}
