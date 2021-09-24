package com.pasta.aglioeolio.domains.user.repository;

import com.pasta.aglioeolio.config.jpa.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.pasta.aglioeolio.config.jpa.QUser.user;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserQueryRepository {

    private final JPAQueryFactory queryFactory; // 물론 이를 위해서는 빈으로 등록을 해줘야 한다.

    public User findByMtNumber(String mt_number) {
        return queryFactory
                .selectFrom(user)
                .where(user.mt_number.eq(mt_number))
                .fetchOne();
    }

}
