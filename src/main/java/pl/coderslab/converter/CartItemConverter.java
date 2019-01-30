package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.CartItem;
import pl.coderslab.repository.CartItemRepository;

public class CartItemConverter implements Converter<String, CartItem> {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem convert(String s) {
        return cartItemRepository.findOne(Long.parseLong(s));
    }
}
