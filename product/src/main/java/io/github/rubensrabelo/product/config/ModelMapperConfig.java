package io.github.rubensrabelo.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapperConfig modelMapper() {
        return new ModelMapperConfig();
    }
}
