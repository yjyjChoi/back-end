package com.pasta.aglioeolio.domains.category.controller;

import com.pasta.aglioeolio.domains.category.dto.response.CategoryResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findCategories(
    ) {

        List<CategoryResponse> categoryResponse = new ArrayList<>();

        CategoryResponse from = CategoryResponse.builder()
            .id(1L)
            .name("금품갈취")
            .build();

        CategoryResponse from2 = CategoryResponse.builder()
            .id(2L)
            .name("성관련 폭행")
            .build();

        categoryResponse.add(from);
        categoryResponse.add(from2);

        return ResponseEntity.ok(categoryResponse);
    }

}
