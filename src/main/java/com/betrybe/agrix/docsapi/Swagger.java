package com.betrybe.agrix.docsapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

/**
 * The type Jwt swagger.
 */
@SuppressWarnings("ALL")
@Configuration
public class Swagger implements OpenApiCustomizer {

  /**
   * The Scheme name.
   */
  public final String schemeName = "Bearer Auth";

  @Override
  public void customise(OpenAPI openApi) {
    Info info = new Info()
        .title("Gestão de Fazendas - Agrix API")
        .description("""
            Agrix é uma API RESTful que facilita a gestão de Fazendas de Plantação.

            Com essa API, é possível cadastrar, buscar, atualizar e deletar informações sobre
            as fazendas, plantações, e os fertilizantes, sendo as buscas filtradas por nome ou id.

            Além disso, é possível cadastrar e buscar informações sobre os funcionários que 
            trabalham na fazenda.
            """)
        .version("1.0.0");

    openApi.info(info);

    openApi.getComponents().addSecuritySchemes(schemeName,
        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
    openApi.addSecurityItem(new SecurityRequirement().addList(schemeName));
  }


  /**
   * Forwarded header filter forwarded header filter.
   *
   * @return the forwarded header filter
   */
  @Bean
  ForwardedHeaderFilter forwardedHeaderFilter() {
    return new ForwardedHeaderFilter();
  }
}