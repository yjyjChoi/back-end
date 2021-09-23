package com.pasta.aglioeolio.domains.user.dto.request;

import com.pasta.aglioeolio.config.jpa.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    private String mtNumber;

    @NotBlank
    private String password;

    public User toEntity(){
        return User.builder()
                .mtNumber(mtNumber)
                .password(password)
                .build();
    }

}
