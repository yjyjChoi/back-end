package com.pasta.aglioeolio.domains.wish.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pasta.aglioeolio.common.LoginUser;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WishServiceTest {

    Logger log = (Logger) LoggerFactory.getLogger(WishServiceTest.class);

    @Autowired
    private WishService wishService;

    private LoginUser loginUser;

    @BeforeEach
    void beforeEach() {
        loginUser = new LoginUser(1L);
    }

    @Test
    @DisplayName("")
    void findAllWish(){
        //given

        //when
        List<WishResponse> wishs = wishService.findAllWish(loginUser);

        log.info(wishs.toString());

        //then
        wishs.forEach( wishResponse -> {
            assertAll(
                () -> assertNotNull(wishResponse.getTitle()),
                () -> assertNotNull(wishResponse.getContent()),
                () -> assertNotNull(wishResponse.getRound()),
                () -> assertNotNull(wishResponse.getIsAnonymous()),
                () -> assertNotNull(wishResponse.getCategoryName()),
                () -> assertNotNull(wishResponse.getUser().getMtNumber()),
                () -> assertNotNull(wishResponse.getUser().getMtNumber()),
                () -> assertNotNull(wishResponse.getUser().getName()),
                () -> assertNotNull(wishResponse.getUser().getRank()),
                () -> assertNotNull(wishResponse.getUser().getAffiliation()),
                () -> assertNotNull(wishResponse.getUser().getProfileImage())
            );
        });

    }

}