package com.pasta.aglioeolio.domains.wish.controller;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pasta.aglioeolio.BaseControllerTest;
import com.pasta.aglioeolio.documentation.WishDocumentation;
import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class WishControllerTest extends BaseControllerTest {

    private static final String BEGIN_URL = "/api/wishs";

    @DisplayName("게시글 다건 조회")
    @Test
    void findAllWish() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(WishDocumentation.findAllWish());
    }

    @DisplayName("게시글 단건 조회")
    @Test
    void findWishById() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL + "/{wishId}", 1)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(WishDocumentation.findWishById());
    }

    @DisplayName("게시글 등록")
    @Test
    void createWish() throws Exception {
        CreateWishRequest createWishRequest = new CreateWishRequest("제목", "내용");

        this.mockMvc.perform(post(BEGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createWishRequest))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(WishDocumentation.createWish());
    }

}