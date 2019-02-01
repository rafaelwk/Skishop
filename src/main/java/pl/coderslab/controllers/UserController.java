package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Cart;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.ProductType;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CartRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.services.UserService;
import pl.coderslab.validator.groups.ValidationLoginGroup;
import pl.coderslab.validator.groups.ValidationRegisterGroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @GetMapping("/formfull")
    public String addUserFull(HttpSession session, Model model, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("formAction", request.getContextPath() + "/user/savefull");
        return "user/formfull";

    }

    @PostMapping("/savefull")
    public String save(HttpSession session, @Validated(ValidationRegisterGroup.class) User user, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "user/formfull";
        }
        userRepository.save(user);
        session.setAttribute("user", user);
        return "redirect:"+request.getContextPath()+"/cart/send";
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


    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @ModelAttribute("carts")
    public List<Cart> productList() {
        return cartRepository.findAll();
    }

}
