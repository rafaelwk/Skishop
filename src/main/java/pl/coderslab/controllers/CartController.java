package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Cart;
import pl.coderslab.entity.CartItem;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CartItemRepository;
import pl.coderslab.repository.CartRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.services.CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/summary")
    public String add(HttpSession session, Model model, HttpServletRequest request) {
        Cart cart =(Cart) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        model.addAttribute("formAction", request.getContextPath() + "/cart/save");
        int sum = cartService.findSum(cart);
        List<CartItem> cartItems =  cartItemRepository.findAllByCart(cart);

        model.addAttribute("sum", sum);
        model.addAttribute("cartItems", cartItems);

        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:"+request.getContextPath()+"/login/form";
        }
        return "cart/summary";
    }

    @PostMapping("/save")
    public String add(HttpSession session, @Valid Cart cart, BindingResult error, Model model, HttpServletRequest request, @PathVariable Long productId) {

        User user = (User) session.getAttribute("user");
        if(user == null) {
            return "redirect:" + request.getContextPath() + "/login/form";
        }
        cart.setStatus("order");

        cartRepository.save(cart);
        return "redirect:"+request.getContextPath()+"/cart/list";

    }

    @GetMapping("/send")
    public String edit(HttpSession session ,Model model){
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        List<CartItem> cartItems =  cartItemRepository.findAllByCart(cart);
        int sum = cartService.findSum(cart);

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("sum", sum);

        return "cart/send";
    }

    @GetMapping("/finish")
    public String finish(HttpSession session, HttpServletRequest request){
        Cart cart = (Cart) session.getAttribute("cart");
        session.removeAttribute("cart");
        return "redirect:"+request.getContextPath()+"/";
    }


    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("cart", cartRepository.findAll());
        return "cart/list";
    }

}
