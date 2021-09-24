package com.pasta.aglioeolio.domains.user.controller;

import com.pasta.aglioeolio.BaseControllerTest;
import com.pasta.aglioeolio.documentation.UserDocumentation;
import com.pasta.aglioeolio.domains.user.dto.request.CreateUserRequest;
import com.pasta.aglioeolio.domains.user.dto.request.UpdateUserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends BaseControllerTest {

    private static final String BEGIN_URL = "/api/users";

    @DisplayName("유저 다건 조회")
    @Test
    void findAllUser() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(UserDocumentation.findAllUser());
    }

    @DisplayName("유저 단건 조회")
    @Test
    void findUserById() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL + "/{userId}", 1))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(UserDocumentation.findUserById());
    }

    @DisplayName("유저 등록")
    @Test
    void createUser() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest(
            "군번", "비밀번호", "입대일자", "전역일자", "이름", "핸드폰번호",
            "계급", "소속", "프로필사진"
        );
        this.mockMvc.perform(post(BEGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createUserRequest))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(UserDocumentation.createUser());
    }

    @DisplayName("유저 수정")
    @Test
    void updateUser() throws Exception {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest(
                "군번", "비밀번호", "입대일자", "전역일자", "이름", "핸드폰번호",
                "계급", "소속", "프로필사진", false, "권한", 0, false
        );
        this.mockMvc.perform(patch(BEGIN_URL+ "/{userId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateUserRequest))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(UserDocumentation.updateUser());
    }

    @DisplayName("유저 삭제")
    @Test
    void deleteUser() throws Exception {
        this.mockMvc.perform(delete(BEGIN_URL+"/{userId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isNoContent())
            .andDo(UserDocumentation.deleteUser());
    }

}