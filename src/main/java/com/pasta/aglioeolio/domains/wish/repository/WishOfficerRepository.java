package com.pasta.aglioeolio.domains.wish.repository;

import com.pasta.aglioeolio.config.jpa.OfficerWish;
import com.pasta.aglioeolio.config.jpa.QCategory;
import com.pasta.aglioeolio.config.jpa.QOfficerWish;
import com.pasta.aglioeolio.config.jpa.QUser;
import com.pasta.aglioeolio.config.jpa.QWish;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class WishOfficerRepository extends QuerydslRepositorySupport {

    public WishOfficerRepository() {
        super(WishOfficerRepository.class);
    }

    @Override
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    private JPAQueryFactory queryFactory;
    private final QWish wish = QWish.wish;
    private final QUser user = QUser.user;
    private final QOfficerWish officerWish = QOfficerWish.officerWish;
    private final QCategory category = QCategory.category;

    public List<OfficerWish> findAllByWishId(Long wishId) {
        return this.queryFactory
            .selectFrom(officerWish)
            .where(
                condition(wishId, officerWish.wish_id::eq)
            )
            .fetch();
    }

    public void saveAll(List<OfficerWish> officerWishes) {
        for (OfficerWish officerWish : officerWishes) {
            super.getEntityManager().persist(officerWish);
        }
    }

    public long deleteOfficerWishByWishId(Long wishId) {
        return queryFactory.delete(officerWish)
            .where(
                condition(wishId, officerWish.wish_id::eq)
            )
            .execute();
    }

    private <T> BooleanExpression condition(T value, Function<T, BooleanExpression> function) {
        return Optional.ofNullable(value).map(function).orElse(null);
    }

}