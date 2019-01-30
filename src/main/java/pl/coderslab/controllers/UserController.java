package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Cart;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CartRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.services.UserService;
import pl.coderslab.validator.groups.ValidationLoginGroup;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/form")
    public String addUser(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        model.addAttribute("formAction", request.getContextPath() + "/user/save");
        return "user/form";

    }

    @PostMapping("/save")
    public String saveBook(@Validated({ValidationLoginGroup.class}) User user, BindingResult errors, HttpServletRequest request, @RequestParam String pwd2) {
        if (errors.hasErrors()) {
            return "user/form";
        }

        try {
            userService.registerUser(user, pwd2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + request.getContextPath() + "/";

    }

    @ModelAttribute("carts")
    public List<Cart> productList() {
        return cartRepository.findAll();
    }

}
