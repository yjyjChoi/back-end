package com.pasta.aglioeolio.domains.wish.repository;

import static com.pasta.aglioeolio.common.enums.BooleanType.FALSE;

import com.pasta.aglioeolio.config.jpa.QCategory;
import com.pasta.aglioeolio.config.jpa.QOfficerWish;
import com.pasta.aglioeolio.config.jpa.QUser;
import com.pasta.aglioeolio.config.jpa.QWish;
import com.pasta.aglioeolio.domains.wish.dto.query.WishQueryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WishQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final QWish wish = QWish.wish;
    private final QUser user = QUser.user;
    private final QOfficerWish officerWish = QOfficerWish.officerWish;
    private final QCategory category = QCategory.category;

    public List<WishQueryDto> findAllWish(Long id) {
        return this.queryFactory
            .select(Projections.fields(
                WishQueryDto.class
                , wish.id
                , wish.title
                , wish.content
                , wish.round
                , wish.is_anonymous.as("isAnonymous")
                , category.name.as("categoryName")
                , user.mt_number.as("mtNumber")
                , user.name.as("userName")
                , user.rank
                , user.affiliation
                , user.profile_image.as("profileImage")
            ))
            .from(wish)
            .join(category).on(wish.category_id.eq(category.id))
            .join(user).on(wish.soldier_id.eq(user.id))
            .where(
                condition(1L, user.id::eq) //TODO: LoginUser 적용 후 교체
                    .and(wish.is_delyn.eq(FALSE.getStatus())
                        .and(user.is_delyn.eq(FALSE.getStatus()))

                    ))
            .fetch();
    }

    public WishQueryDto findWishById(Long wishId) {
        return this.queryFactory
            .select(Projections.fields(
                WishQueryDto.class
                , wish.id
                , wish.title
                , wish.content
                , wish.round
                , wish.is_anonymous.as("isAnonymous")
                , category.name.as("categoryName")
                , user.mt_number.as("mtNumber")
                , user.name.as("userName")
                , user.rank
                , user.affiliation
                , user.profile_image.as("profileImage")
            ))
            .from(wish)
            .join(category).on(wish.category_id.eq(category.id))
            .join(user).on(wish.soldier_id.eq(user.id))
            .where(
                condition(wishId, wish.id::eq)
                    .and(wish.is_delyn.eq(FALSE.getStatus())
                        .and(user.is_delyn.eq(FALSE.getStatus()))
                    ))
            .fetchOne();
    }

    private <T> BooleanExpression condition(T value, Function<T, BooleanExpression> function) {
        return Optional.ofNullable(value).map(function).orElse(null);
    }

}