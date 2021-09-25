package com.pasta.aglioeolio.domains.wish.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pasta.aglioeolio.config.jpa.User;
import com.pasta.aglioeolio.config.jpa.Wish;
import com.pasta.aglioeolio.domains.user.dto.response.UserResponse;
import com.pasta.aglioeolio.domains.wish.dto.query.WishQueryDto;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WishResponse {

    private Long id;
    private String title;
    private String content;
    private Integer round;

    private Boolean verificationSoldier;
    private List<Long> officers;
    private Boolean isAnonymous;

    private String categoryName;

    private UserResponse user;

    public static WishResponse of(Wish wish, User user, String categoryName){
        return WishResponse.builder()
            .id(wish.getId())
            .title(wish.getTitle())
            .content(wish.getContent())
            .round(wish.getRound())
            .categoryName(categoryName)
            .isAnonymous(wish.getIs_anonymous())
            .user(userResponse(user))
            .build();
    }

    public static WishResponse of(WishQueryDto wishQueryDto){
        return WishResponse.builder()
            .id(wishQueryDto.getWishId())
            .title(wishQueryDto.getTitle())
            .content(wishQueryDto.getContent())
            .round(wishQueryDto.getRound())
            .categoryName(wishQueryDto.getCategoryName())
            //.verificationSoldier()
            //.officers()
            .isAnonymous(wishQueryDto.getIsAnonymous())
            .user(userResponse(wishQueryDto))
            .build();
    }

    public static List<WishResponse> listOf(List<WishQueryDto> wishQueryDtos){
        List<WishResponse> wishResponses = new ArrayList<>();
        for (WishQueryDto wishQueryDto : wishQueryDtos) {
            wishResponses.add(of(wishQueryDto));
        }
        return  wishResponses;
    }

    private static UserResponse userResponse(WishQueryDto wishQueryDto){
        return UserResponse.builder()
            .mtNumber(wishQueryDto.getMtNumber())
            .name(wishQueryDto.getUserName())
            .rank(wishQueryDto.getRank())
            .affiliation(wishQueryDto.getAffiliation())
            .profileImage(wishQueryDto.getProfileImage())
            .build();
    }

    private static UserResponse userResponse(User user){
        return UserResponse.builder()
            .mtNumber(user.getMt_number())
            .name(user.getName())
            .rank(user.getRank())
            .affiliation(user.getAffiliation())
            .profileImage(user.getProfile_image())
            .build();
    }

}