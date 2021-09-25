package com.pasta.aglioeolio.domains.wish.dto.request;

import com.pasta.aglioeolio.config.jpa.OfficerWish;
import com.pasta.aglioeolio.config.jpa.User;
import com.pasta.aglioeolio.config.jpa.Wish;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWishRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Integer round;

    @NotNull
    private Boolean isAnonymous;

    @NotNull
    private Long categoryId;

    List<Long> officers;

    public Wish toWishEntity(User user) {
        return Wish.builder()
            .title(title)
            .content(content)
            .round(round)
            .is_anonymous(isAnonymous)
            .is_delyn(Boolean.FALSE)
            .category_id(categoryId)
            .soldier_id(user.getId())
            .build();
    }

    public List<OfficerWish> toOfficerWishEntity(Long wishId) {
        List<OfficerWish> officerWishes = new ArrayList<>();

        for (Long officer : officers) {
            OfficerWish officerWish = OfficerWish.builder()
                .officer_id(officer)
                .wish_id(wishId)
                .is_checked(Boolean.FALSE)
                .build();
            officerWishes.add(officerWish);
        }

        return officerWishes;
    }

}