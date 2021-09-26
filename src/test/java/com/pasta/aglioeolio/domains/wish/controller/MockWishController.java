package com.pasta.aglioeolio.domains.wish.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pasta.aglioeolio.MockBaseControllerTest;
import com.pasta.aglioeolio.documentation.WishDocumentation;
import com.pasta.aglioeolio.domains.user.dto.response.UserResponse;
import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.UpdateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import com.pasta.aglioeolio.domains.wish.service.WishService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

@WebMvcTest(value = WishController.class)
public class MockWishController extends MockBaseControllerTest {

    private static final String BEGIN_URL = "/api/wishs";

    @MockBean
    private WishService wishService;

    private UserResponse userResponse;

    @BeforeEach
    void beforeEach(){
        userResponse = UserResponse.builder()
            .mtNumber("15-72005960")
            .name("김우철")
            .rank("병장")
            .affiliation("112연대 1대대")
            .profileImage("http://www.naver.com")
            .build();
    }

    @DisplayName("소원 다건 조회")
    @Test
    void findAllWish() throws Exception {

        //given
        List<WishResponse> wishs = new ArrayList<>();

        WishResponse wishResponse = WishResponse.builder()
            .id(1L)
            .title("제목1")
            .content("내용1")
            .round(1)
            .categoryName("카테고리1")
            .isAnonymous(true)
            .user(userResponse)
            .build();

        WishResponse wishResponse2 = WishResponse.builder()
            .id(2L)
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

    @DisplayName("소원 단건 조회")
    @Test
    void findWishById() throws Exception {

        //given
        WishResponse wishResponse = WishResponse.builder()
            .id(1L)
            .title("제목1")
            .content("내용1")
            .round(1)
            .categoryName("카테고리1")
            .isAnonymous(true)
            .user(userResponse)
            .build();

        given(wishService.findWishById(any())).willReturn(wishResponse);

        String responseBody = objectMapper.writeValueAsString(wishResponse);

        //when & then
        this.mockMvc.perform(get(BEGIN_URL + "/{wishId}", 1)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(responseBody))
            .andDo(WishDocumentation.findWishById());
    }

    @DisplayName("소원 등록")
    @Test
    void createWish() throws Exception {

        //given
        CreateWishRequest createWishRequest = new CreateWishRequest(
            "제목", "내용", 1, true, 1L, Arrays.asList(1L, 2L, 3L)
        );

        WishResponse wishResponse = WishResponse.builder()
            .id(1L)
            .title("제목1")
            .content("내용1")
            .round(1)
            .categoryName("카테고리1")
            .isAnonymous(true)
            .user(userResponse)
            .build();

        given(wishService.createWish(any(), any())).willReturn(wishResponse);

        String requestBody = objectMapper.writeValueAsString(createWishRequest);
        String responseBody = objectMapper.writeValueAsString(wishResponse);

        //when & then
        this.mockMvc.perform(post(BEGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().string(responseBody))
            .andDo(WishDocumentation.createWish());
    }

    @DisplayName("소원 수정")
    @Test
    void updateWish() throws Exception {
        //given
        UpdateWishRequest updateWishRequest = new UpdateWishRequest(
            "제목", "내용", 1, true, 1L, Arrays.asList(1L, 2L, 3L)
        );

        WishResponse wishResponse = WishResponse.builder()
            .id(1L)
            .title("제목_수정")
            .content("내용_수정")
            .round(1)
            .categoryName("카테고리_수정")
            .isAnonymous(true)
            .user(userResponse)
            .build();

        given(wishService.updateWish(any(), any(), any())).willReturn(wishResponse);

        String requestBody = objectMapper.writeValueAsString(updateWishRequest);
        String responseBody = objectMapper.writeValueAsString(wishResponse);

        //when & then
        this.mockMvc.perform(patch(BEGIN_URL+ "/{wishId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(responseBody))
            .andDo(WishDocumentation.updateWish());
    }

}