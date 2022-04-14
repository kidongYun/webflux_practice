package com.kian.yun.webflux_practice.rest.handler;

import com.kian.yun.webflux_practice.domain.service.AliasService;
import com.kian.yun.webflux_practice.rest.dto.AliasDto;
import com.kian.yun.webflux_practice.rest.mapper.AliasMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class AliasHandler {
    private final AliasService aliasService;
    private final AliasMapper aliasMapper;

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(AliasDto.Save.Req.class)
                .flatMap(request -> aliasService.save(aliasMapper.toDomain(request)))
                .flatMap(request -> ServerResponse.ok().bodyValue(request));
    }

    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        return aliasService.findById(Long.parseLong(serverRequest.pathVariable("id")))
                .flatMap(request -> ServerResponse.ok().bodyValue(request));
    }

    public Mono<ServerResponse> getList(ServerRequest serverRequest) {
        return aliasService.find()
                .collectList()
                .flatMap(request -> ServerResponse.ok().bodyValue(request));
    }

    public Mono<ServerResponse> put(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<ServerResponse> getStatus(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<ServerResponse> fluxToMono(ServerRequest serverRequest) {
        return ServerResponse.ok().body(Flux.range(1, 6), Integer.class);
    }

    public Mono<ServerResponse> fluxCreate(ServerRequest serverRequest) {
        Flux<Integer> flux = Flux.create((FluxSink<Integer> sink) -> {
            sink.onRequest(request -> {
                for (int i=0; i<=request + 3; i++) {
                    sink.next(i);
                }
            });
        });

        log.info(flux.toString());
        return Mono.empty();
    }
}
