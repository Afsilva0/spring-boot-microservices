package co.com.personalsoft.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/*Ya que la libreria de Swagger no se ha actualizado presenta errores de compatibilidad
 *Con las nuevas versiones de Spring Boot
 */

/*

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
   public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //.apis(RequestHandlerSelectors.basePackage("com.codmind.swaggerapi.controllers"))
                .paths(PathSelectors.any())
                .build();
               // .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Order Service API",
                "Order Service API Description",
                "1.0",
                "http://codmind.com/terms",
                new Contact("Codmind", "https://codmind.com", "apis@codmind.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}

 */