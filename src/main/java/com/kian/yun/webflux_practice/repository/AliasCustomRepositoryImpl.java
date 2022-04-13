package com.kian.yun.webflux_practice.repository;

import com.kian.yun.webflux_practice.domain.Alias;
import com.kian.yun.webflux_practice.domain.QAlias;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AliasCustomRepositoryImpl extends QuerydslRepositorySupport implements AliasCustomRepository {
    private static final QAlias alias = QAlias.alias;
    private JPAQueryFactory queryFactory;

    public AliasCustomRepositoryImpl() {
        super(Alias.class);
    }

    @Override
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
        this.queryFactory = new JPAQueryFactory(entityManager);
    }
}
