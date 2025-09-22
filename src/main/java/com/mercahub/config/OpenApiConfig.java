package com.mercahub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  OpenAPI mercahubOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Mercahub API")
                .description("API inspirada no Mercado Livre")
                .version("v1"));
  }
}
