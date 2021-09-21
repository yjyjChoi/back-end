package com.pasta.aglioeolio.domains.category.controller;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pasta.aglioeolio.BaseControllerTest;
import com.pasta.aglioeolio.documentation.CategoryDocumentation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryControllerTest extends BaseControllerTest {

    private static final String BEGIN_URL = "/api/categories";

    @DisplayName("카테고리 전체 조회")
    @Test
    void findAllWish() throws Exception {
        this.mockMvc.perform(get(BEGIN_URL))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(CategoryDocumentation.findCategories());
    }

}