package com.pasta.aglioeolio.domains.category.controller;

import com.pasta.aglioeolio.domains.category.dto.response.CategoryResponse;
import com.pasta.aglioeolio.domains.category.service.CategoryService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(
        CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findCategories(
    ) {
        return ResponseEntity.ok(categoryService.findCategories());
    }

}