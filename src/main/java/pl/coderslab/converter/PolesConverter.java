package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Poles;
import pl.coderslab.repository.PolesRepository;

public class PolesConverter implements Converter<String, Poles> {

    @Autowired
    private PolesRepository polesRepository;

    @Override
    public Poles convert(String s) {
        return polesRepository.findOne(Long.parseLong(s));
    }
}
