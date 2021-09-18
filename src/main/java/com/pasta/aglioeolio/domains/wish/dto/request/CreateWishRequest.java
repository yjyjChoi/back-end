package com.pasta.aglioeolio.domains.wish.dto.request;

import javax.validation.constraints.NotBlank;
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

}