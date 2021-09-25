package com.pasta.aglioeolio.domains.wish.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pasta.aglioeolio.MockBaseControllerTest;
import com.pasta.aglioeolio.documentation.WishDocumentation;
import com.pasta.aglioeolio.domains.user.dto.response.UserResponse;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import com.pasta.aglioeolio.domains.wish.service.WishService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MockWishController extends MockBaseControllerTest {

    private static final String BEGIN_URL = "/api/wishs";

    @MockBean
    private WishService wishService;

    @DisplayName("소원 다건 조회")
    @Test
    void findAllWish() throws Exception {

        //given
        List<WishResponse> wishs = new ArrayList<>();

        UserResponse userResponse = UserResponse.builder()
            .mtNumber("15-72005960")
            .name("김우철")
            .rank("병장")
            .affiliation("112연대 1대대")
            .profileImage("http://www.naver.com")
            .build();

        WishResponse wishResponse = WishResponse.builder()
            .title("제목1")
            .content("내용1")
            .round(1)
            .categoryName("카테고리1")
            .isAnonymous(true)
            .user(userResponse)
            .build();

        WishResponse wishResponse2 = WishResponse.builder()
            .title("제목2")
            .content("내용2")
            .round(1)
            .categoryName("카테고리21")
            .isAnonymous(true)
            .user(userResponse)
            .build();

        wishs.add(wishResponse);
        wishs.add(wishResponse2);

        given(wishService.findAllWish(any())).willReturn(wishs);

        String responseBody = objectMapper.writeValueAsString(wishs);

        //when & then
        this.mockMvc.perform(get(BEGIN_URL))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(responseBody))
            .andDo(WishDocumentation.findAllWish());
    }

}