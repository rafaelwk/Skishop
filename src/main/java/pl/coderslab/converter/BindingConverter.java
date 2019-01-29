package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Binding;
import pl.coderslab.repository.BindingRepository;

public class BindingConverter implements Converter<String, Binding> {

    @Autowired
    private BindingRepository bindingRepository;

    @Override
    public Binding convert(String s) {
        return bindingRepository.findOne(Long.parseLong(s));
    }
}
