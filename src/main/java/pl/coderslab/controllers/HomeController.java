package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.ProductType;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ProductTypeRepository;

import javax.servlet.http.HttpSession;


@Controller

public class HomeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("")
    public String showAll(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("productTypes",productTypeRepository.findAll());
        return "home";
    }
}
