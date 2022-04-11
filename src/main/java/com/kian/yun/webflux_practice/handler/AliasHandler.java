package com.kian.yun.webflux_practice.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AliasHandler {
    public Mono<ServerResponse> getStatus(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<ServerResponse> fluxToMono(ServerRequest serverRequest) {
        return ServerResponse.ok().body(Flux.range(1, 6), Integer.class);
    }
}
