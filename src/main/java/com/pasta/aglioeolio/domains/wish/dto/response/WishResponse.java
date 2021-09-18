package com.pasta.aglioeolio.domains.wish.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishResponse {
    private String title;
    private String content;

    public static WishResponse from(){
        return WishResponse.builder()
            .title("제목")
            .content("내용")
            .build();
    }

}