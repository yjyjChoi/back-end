package com.pasta.aglioeolio.domains.wish.dto.request;

import java.util.List;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteWishRequest {

    @Size(min = 1)
    private List<Long> wishIds;

}