package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Boot;
import pl.coderslab.repository.BootRepsitory;

public class BootConverter implements Converter<String, Boot> {

    @Autowired
    private BootRepsitory bootRepsitory;

    @Override
    public Boot convert(String s) {
        return bootRepsitory.findOne(Long.parseLong(s));
    }
}
