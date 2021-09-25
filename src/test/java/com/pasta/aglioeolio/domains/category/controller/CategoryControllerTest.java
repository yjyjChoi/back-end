package com.pasta.aglioeolio.domains.category.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pasta.aglioeolio.MockBaseControllerTest;
import com.pasta.aglioeolio.documentation.CategoryDocumentation;
import com.pasta.aglioeolio.domains.category.dto.response.CategoryResponse;
import com.pasta.aglioeolio.domains.category.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(value = CategoryController.class)
class CategoryControllerTest extends MockBaseControllerTest {

    private static final String BEGIN_URL = "/api/categories";

    @MockBean
    private CategoryService categoryService;

    @DisplayName("카테고리 전체 조회")
    @Test
    void findAllWish() throws Exception {

        //given
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        CategoryResponse categoryResponse = CategoryResponse.builder()
            .id(1L)
            .name("카테고리 이름1")
            .build();

        CategoryResponse categoryResponse2 = CategoryResponse.builder()
            .id(2L)
            .name("카테고리 이름2")
            .build();

        categoryResponses.add(categoryResponse);
        categoryResponses.add(categoryResponse2);

        given(categoryService.findCategories()).willReturn(categoryResponses);

        String responseBody = objectMapper.writeValueAsString(categoryResponses);

        //when & then
        this.mockMvc.perform(get(BEGIN_URL))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(responseBody))
            .andDo(CategoryDocumentation.findCategories());
    }

}