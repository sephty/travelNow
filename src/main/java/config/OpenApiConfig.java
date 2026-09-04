package config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI logiTrackOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("LogiTrack API")
                        .description("Sistema de gestion de bodegas y productos. " +
                                "Permite administrar bodegas, productos")
                        .version("v0.1"))
                .tags(List.of(
                        new Tag().name("Productos").description("CRUD y filtros de productos del inventario"),
                        new Tag().name("Bodegas").description("CRUD de bodegas distribuidas por ciudad")
                ));
    }
}