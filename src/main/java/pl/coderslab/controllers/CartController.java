package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Binding;
import pl.coderslab.entity.Cart;
import pl.coderslab.repository.BindingRepository;
import pl.coderslab.repository.CartRepository;
import pl.coderslab.repository.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("cart", new Cart());
        model.addAttribute("formAction", request.getContextPath() + "/cart/save");
        return "cart/form";

    }


//    @ModelAttribute("bindings")
//    public List<Binding> bindingList() {
//        return bindingRepository.findAll();
//    }
}
