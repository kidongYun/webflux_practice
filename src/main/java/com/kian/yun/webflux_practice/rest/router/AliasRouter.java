package com.kian.yun.webflux_practice.rest.router;

import com.kian.yun.webflux_practice.rest.handler.AliasHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.nio.charset.Charset;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AliasRouter {

    final MediaType APPLICATION_JSON_CP949 = new MediaType(MediaType.APPLICATION_JSON, Charset.forName("CP949"));

    @Bean
    public RouterFunction<ServerResponse> aliasRoute(AliasHandler aliasHandler) {
        return route()
                .path("/alias/v1", builder -> builder
                        .POST("/", aliasHandler::save)
                        .GET("/{id}", aliasHandler::get)
                        .GET("/", aliasHandler::getList)
                        .PUT("/{id}", aliasHandler::put)
                        .DELETE("/{id}", aliasHandler::delete)

                        .GET("/fluxToMono", aliasHandler::fluxToMono)
                        .GET("/fluxCreate", aliasHandler::fluxCreate)
                ).build();
    }
}
