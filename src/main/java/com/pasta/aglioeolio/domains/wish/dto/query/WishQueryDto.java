package com.pasta.aglioeolio.domains.wish.dto.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishQueryDto {

    //wish
    private Long wishId;
    private String title;
    private String content;
    private Integer round;
    private Boolean isAnonymous;

    //caategory
    private String categoryName;

    //user
    private String mtNumber;
    private String userName;
    private String rank;
    private String affiliation;
    private String profileImage;

}