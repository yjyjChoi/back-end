package com.pasta.aglioeolio.domains.user.controller;

import com.pasta.aglioeolio.BaseControllerTest;
import com.pasta.aglioeolio.documentation.CategoryDocumentation;
import com.pasta.aglioeolio.documentation.UserDocumentation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends BaseControllerTest {

    private static final String BEGIN_URL = "/api/user";

    @DisplayName("유저 전체 조회")
    @Test
    void findAllUser() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(UserDocumentation.findAllUser());
    }

}