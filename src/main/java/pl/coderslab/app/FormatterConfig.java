package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.*;

@Configuration
@ComponentScan("pl.coderslab")
@EnableWebMvc
@EnableTransactionManagement
public class FormatterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getUserConverter());
        registry.addConverter(getProductTypeConverter());
        registry.addConverter(getProductConverter());
        registry.addConverter(getCartItemConverter());
        registry.addConverter(getCartConverter());
    }

    @Bean
    public UserConverter getUserConverter(){
        return new UserConverter();
    }

    @Bean
    public ProductTypeConverter getProductTypeConverter() {
        return new ProductTypeConverter();
    }

    @Bean
    public ProductConverter getProductConverter() {
        return new ProductConverter();
    }

    @Bean
    public CartItemConverter getCartItemConverter() {
        return new CartItemConverter();
    }

    @Bean
    public CartConverter getCartConverter() {
        return new CartConverter();
    }


}
