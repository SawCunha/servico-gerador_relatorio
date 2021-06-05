package com.sawcunha.controlerelatorio;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
@EnableAdminServer
public class ControleRelatorioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleRelatorioApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application.description}") String description, @Value("${application.version}") String version){
        return new OpenAPI().info(new Info()
                .title(description)
                .version(version)
                .termsOfService("https://swagger.io/terms")
                .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }

}
