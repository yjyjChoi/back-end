package com.pasta.aglioeolio.domains.category.dto.response;

import com.pasta.aglioeolio.config.jpa.Category;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private Long id;
    private String name;

    public static CategoryResponse of(Category category){
        return CategoryResponse.builder()
            .id(category.getId())
            .name(category.getName())
            .build();
    }

    public static List<CategoryResponse> listOf(List<Category> categories){
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories) {
            categoryResponses.add(of(category));
        }
        return  categoryResponses;
    }

}