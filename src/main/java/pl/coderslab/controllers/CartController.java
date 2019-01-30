package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Cart;
import pl.coderslab.entity.CartItem;
import pl.coderslab.entity.Product;
import pl.coderslab.repository.CartItemRepository;
import pl.coderslab.repository.CartRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product/ski")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("cart", new Cart());
        model.addAttribute("formAction", request.getContextPath() + "cart/save");
        return "cart/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        Cart cart = cartRepository.findOne(id);
        model.addAttribute("cart", cart);
        model.addAttribute("formAction", request.getContextPath() + "cart/save");
        return "cart/form";
    }

    @PostMapping("/save")
    public String save(@Valid Cart cart, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "product/ski/form";
        }
        cartRepository.save(cart);
        return "redirect:"+request.getContextPath()+"cart/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("cart", cartRepository.findAll());
        return "cart/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Cart cart = cartRepository.findOne(id);
        cartRepository.delete(cart);
        return "redirect:" + request.getContextPath() + "/cart/list";
    }

    @ModelAttribute("cartItems")
    public List<CartItem> productList() {
        return cartItemRepository.findAll();
    }
}
