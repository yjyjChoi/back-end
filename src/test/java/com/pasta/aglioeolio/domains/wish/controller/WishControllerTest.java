package com.pasta.aglioeolio.domains.wish.controller;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pasta.aglioeolio.BaseControllerTest;
import com.pasta.aglioeolio.documentation.WishDocumentation;
import com.pasta.aglioeolio.domains.wish.dto.request.CreateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.UpdateWishRequest;
import com.pasta.aglioeolio.domains.wish.dto.request.VerificationWishRequest;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class WishControllerTest extends BaseControllerTest {

    private static final String BEGIN_URL = "/api/wishs";

//    @DisplayName("소원 다건 조회")
//    @Test
//    void findAllWish() throws Exception {
//        this.mockMvc.perform(get(BEGIN_URL))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andDo(WishDocumentation.findAllWish());
//    }

    @DisplayName("소원 단건 조회")
    @Test
    void findWishById() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL + "/{wishId}", 1)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(WishDocumentation.findWishById());
    }

    @DisplayName("소원 등록")
    @Test
    void createWish() throws Exception {
        CreateWishRequest createWishRequest = new CreateWishRequest(
            "제목", "내용", 1, true, 1L, Arrays.asList(1L, 2L, 3L)
        );

        this.mockMvc.perform(post(BEGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createWishRequest))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(WishDocumentation.createWish());
    }

    @DisplayName("소원 수정")
    @Test
    void updateWish() throws Exception {
        UpdateWishRequest updateWishRequest = new UpdateWishRequest(
            "제목", "내용", 1, true, 1L, Arrays.asList(1L, 2L, 3L)
        );

        this.mockMvc.perform(patch(BEGIN_URL+ "/{wishId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateWishRequest))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(WishDocumentation.updateWish());
    }

    @DisplayName("소원 삭제")
    @Test
    void deleteWish() throws Exception {

        this.mockMvc.perform(delete(BEGIN_URL+"/{wishId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isNoContent())
            .andDo(WishDocumentation.deleteWish());
    }

    @DisplayName("간부가 읽은 소원에 대한 확인")
    @Test
    void verificationWishBySoldier() throws Exception {
        VerificationWishRequest verificationWishRequest = new VerificationWishRequest(
            Arrays.asList(1L, 2L, 3L)
        );

        this.mockMvc.perform(post(BEGIN_URL + "/verification/soldier")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(verificationWishRequest))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isNoContent())
            .andDo(WishDocumentation.verificationWishBySoldier());
    }

}