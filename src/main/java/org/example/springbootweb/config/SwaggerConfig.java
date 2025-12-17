package org.example.springbootweb.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API文档",
        version = "1.0.0",
        description = "Spring Boot Web API 说明文档"
    )
)
public class SwaggerConfig {
}