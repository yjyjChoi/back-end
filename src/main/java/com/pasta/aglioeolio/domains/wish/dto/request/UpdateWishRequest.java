package com.pasta.aglioeolio.domains.wish.dto.request;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWishRequest {

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

}