package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Cart;
import pl.coderslab.entity.CartItem;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.ProductType;
import pl.coderslab.repository.CartItemRepository;
import pl.coderslab.repository.CartRepository;
import pl.coderslab.repository.ProductRepsitory;
import pl.coderslab.repository.ProductTypeRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepsitory productRepsitory;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("/form/{productId}")
    public String add(Model model, HttpServletRequest request, @PathVariable Long productId) {
        CartItem cartItem = new CartItem();
        model.addAttribute("cartItem", cartItem);
        model.addAttribute("formAction", request.getContextPath() + "/cartItem/save/" + productId);
        model.addAttribute("product", productRepsitory.findOne(productId));

        return "cartItem/form";
    }

    @PostMapping("/save/{productId}")
    public String add(HttpSession session, @Valid CartItem cartItem, BindingResult error, Model model, HttpServletRequest request, @PathVariable Long productId) {

        Cart cart = (Cart) session.getAttribute("cart");


        if(cart == null){
            cart = new Cart();
            cartRepository.save(cart);
            session.setAttribute("cart", cart);
        }

        Product product = productRepsitory.findOne(productId);
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        if (error.hasErrors()) {
            return "cartItem/form";
        }
        List<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypeRepository.findAll());
        cartItemRepository.save(cartItem);
        return "redirect:"+request.getContextPath()+"/cartItem/list";
    }

    @GetMapping("/list")
    public String showAll(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        List<CartItem> cartItemList = cartItemRepository.findAllByCart(cart);
        model.addAttribute("productTypes", productTypeRepository.findAll());
        model.addAttribute("cartItems", cartItemList);
        return "cartItem/list";
    }



    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        CartItem cartItem = cartItemRepository.findOne(id);
        cartItemRepository.delete(cartItem);
        return "redirect:" + request.getContextPath() + "/cartItem/list";
    }
}
