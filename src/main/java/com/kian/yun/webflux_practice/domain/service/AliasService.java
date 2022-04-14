package com.kian.yun.webflux_practice.domain.service;

import com.kian.yun.webflux_practice.domain.Alias;
import com.kian.yun.webflux_practice.repository.AliasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AliasService {
    private final AliasRepository.Reactive reactiveAliasRepository;

    public Mono<Alias> save(Alias alias) {
        return reactiveAliasRepository.save(alias);
    }

    public Mono<Alias> findById(Long id) {
        return reactiveAliasRepository.findById(id);
    }

    public Flux<Alias> find() {
        return reactiveAliasRepository.findAll();
    }
}
