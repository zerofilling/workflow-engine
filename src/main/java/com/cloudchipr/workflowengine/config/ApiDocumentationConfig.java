package com.cloudchipr.workflowengine.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

@Lazy(false)
@Configuration
@PropertySource("classpath:api-doc.properties")
@EnableConfigurationProperties
public class ApiDocumentationConfig {

  @Bean
  @ConfigurationProperties(prefix = "api-doc")
  OpenAPIProperties openAPIProperties() {
    return new OpenAPIProperties();
  }

  @Bean
  public OpenAPI openAPI() {
    final var apiProperties = openAPIProperties();
    return new OpenAPI()
        .info(new Info()
            .title(apiProperties.getTitle())
            .description(apiProperties.getDescription())
            .version(apiProperties.getVersion()));
  }

  @Setter
  @Getter
  private static class OpenAPIProperties {

    private String title;
    private String description;
    private String version;
  }
}
