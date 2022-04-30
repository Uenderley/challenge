package com.uenderley.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.uenderley.challenge.controller"))
                .paths(regex("/.*"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Challenge Service for Procer")
                .description("Serviço CRUD")
                .version("v1")
                .contact(this.contact())
                .build();
    }

    private Contact contact() {
        return new Contact(
                "",
                "",
                "uenderleymont@uenderley.com.br");
    }
}

