package com.kian.yun.webflux_practice.repository;

import com.kian.yun.webflux_practice.domain.Alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AliasRepository extends JpaRepository<Alias, Long>, QuerydslPredicateExecutor<Alias>, AliasCustomRepository {
}
