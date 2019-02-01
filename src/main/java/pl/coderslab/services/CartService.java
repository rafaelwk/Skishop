package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Cart;
import pl.coderslab.entity.CartItem;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CartItemRepository;
import pl.coderslab.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;


    public Integer findSum(Cart cart){

        List<CartItem> cartItems =  cartItemRepository.findAllByCart(cart);

        int sum =0;
        for(CartItem cartItem : cartItems) {
            sum  += (cartItem.getProduct().getPrice()) *(cartItem.getQuantity());
        }
        return  sum;
    }
}
