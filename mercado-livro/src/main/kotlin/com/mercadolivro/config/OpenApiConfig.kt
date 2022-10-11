package com.mercadolivro.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {


    val securitySchemeName = "bearerAuth";

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .addSecurityItem(SecurityRequirement()
                    .addList(securitySchemeName))
            .components(Components()
                    .addSecuritySchemes(securitySchemeName, io.swagger.v3.oas.models.security.SecurityScheme()
                            .name(securitySchemeName)
                            .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")))
            .info(Info()
                .title("Mercado Livro API")
                .version("1.0")
                .description("API para o Mercado Livro"))
    }
}