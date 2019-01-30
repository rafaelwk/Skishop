package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Cart;
import pl.coderslab.repository.CartRepository;

public class CartConverter implements Converter<String, Cart> {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart convert(String s) {
        return cartRepository.findOne(Long.parseLong(s));
    }
}
