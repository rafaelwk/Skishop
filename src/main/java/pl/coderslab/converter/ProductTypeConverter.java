package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.ProductType;
import pl.coderslab.repository.ProductTypeRepository;

public class ProductTypeConverter implements Converter<String, ProductType> {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public ProductType convert(String s) {
        return productTypeRepository.findOne(Long.parseLong(s));
    }
}
