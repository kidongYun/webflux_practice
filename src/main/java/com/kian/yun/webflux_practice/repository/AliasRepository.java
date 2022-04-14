package com.kian.yun.webflux_practice.repository;

import com.kian.yun.webflux_practice.domain.Alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.scheduler.Scheduler;

@Repository
public interface AliasRepository extends JpaRepository<Alias, Long>, QuerydslPredicateExecutor<Alias>, AliasCustomRepository {
    @Repository
    class Reactive extends ReactiveJpaRepositoryAdapter<Alias, Long, AliasRepository> {
        public Reactive(AliasRepository repository, Scheduler scheduler) {
            super(repository, scheduler);
        }
    }
}
