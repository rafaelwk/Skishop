package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Ski;
import pl.coderslab.repository.SkiRepository;

public class SkiConverter implements Converter<String, Ski> {

    @Autowired
    private SkiRepository skiRepository;

    @Override
    public Ski convert(String s) {
        return skiRepository.findOne(Long.parseLong(s));
    }
}
