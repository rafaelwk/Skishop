package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserRepository userRepository;


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";

    }

    @GetMapping("/form")
    public String addUser(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        model.addAttribute("formAction", request.getContextPath() + "/login/save");
        return "login/form";

    }

    @PostMapping("/save")
    public String saveBook(@Valid User user,
                           BindingResult errors,
                           HttpServletRequest request,
                           HttpSession session) {



        if (errors.hasErrors()) {
            return "login/form";
        }
        if (userService.loginUser(user.getUserName(), user.getPassword(), session) == true) {
            User userLoged = (User) session.getAttribute("user");
            return "redirect:" + request.getContextPath() + "/";
        }
        return "redirect:" + request.getContextPath() + "/product/login/form";


    }
}
