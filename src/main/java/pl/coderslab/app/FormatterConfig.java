package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.*;
import pl.coderslab.entity.CartItem;

@Configuration
@ComponentScan("pl.coderslab")
@EnableWebMvc
@EnableTransactionManagement
public class FormatterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getUserConverter());
        registry.addConverter(getBindingConverter());
        registry.addConverter(getBootConverter());
        registry.addConverter(getPolesConverter());
        registry.addConverter(getSkiConverter());
        registry.addConverter(getCartConverter());
        registry.addConverter(getProductConverter());
        registry.addConverter(getCartItemConverter());
    }

    @Bean
    public UserConverter getUserConverter(){
        return new UserConverter();
    }

    @Bean
    public BindingConverter getBindingConverter() {
        return new BindingConverter();
    }

    @Bean
    public BootConverter getBootConverter() {
        return new BootConverter();
    }

    @Bean
    public PolesConverter getPolesConverter() {
        return new PolesConverter();
    }

    @Bean
    public SkiConverter getSkiConverter() {
        return new SkiConverter();
    }

    @Bean
    public CartConverter getCartConverter() {
        return new CartConverter();
    }

    @Bean
    public ProductConverter getProductConverter() {
        return new ProductConverter();
    }
    @Bean
    public CartItemConverter getCartItemConverter() {
        return new CartItemConverter();
    }


}
