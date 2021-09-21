package com.pasta.aglioeolio.domains.wish.dto.response;

import java.util.List;
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
    private Integer round;
    private Boolean isAnonymous;
    private Long categoryId;
    private Boolean verificationSoldier;
    private List<Long> officers;
}