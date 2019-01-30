package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.CartItem;
import pl.coderslab.repository.CartItemRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    private CartItemRepository cartItemRepository;


    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("formAction", request.getContextPath() + "/cartItem/save");
        return "cartItem/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        CartItem cartItem = cartItemRepository.findOne(id);
        model.addAttribute("cartItem", cartItem);
        model.addAttribute("formAction", request.getContextPath() + "/cartItem/save");
        return "cartItem/form";
    }

    @PostMapping("/save")
    public String save(@Valid CartItem cartItem, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "cartItem/form";
        }
        cartItemRepository.save(cartItem);
        return "redirect:"+request.getContextPath()+"cartItem/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("cartItem", cartItemRepository.findAll());
        return "cartItem/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        CartItem cartItem = cartItemRepository.findOne(id);
        cartItemRepository.delete(cartItem);
        return "redirect:" + request.getContextPath() + "cartItem/list";
    }
}
