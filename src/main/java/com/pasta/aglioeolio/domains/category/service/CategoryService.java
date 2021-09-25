package com.pasta.aglioeolio.domains.category.service;

import com.pasta.aglioeolio.domains.category.dto.response.CategoryResponse;
import com.pasta.aglioeolio.domains.category.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(
        CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponse> findCategories() {
        return CategoryResponse.listOf(categoryRepository.findAll());
    }

}