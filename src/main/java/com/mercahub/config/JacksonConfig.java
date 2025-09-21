package com.mercahub.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    Jackson2ObjectMapperBuilderCustomizer ignoreUnknownPropertiesCustomizer() {
        return builder -> builder
        .failOnUnknownProperties(false);
    }
}
