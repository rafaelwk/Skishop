package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Product;
import pl.coderslab.repository.ProductRepsitory;

public class ProductConverter implements Converter<String, Product> {

    @Autowired
    private ProductRepsitory productRepsitory;

    @Override
    public Product convert(String s) {
        return productRepsitory.findOne(Long.parseLong(s));
    }
}
