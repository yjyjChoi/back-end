package com.pasta.aglioeolio.domains.user.dto.response;

import com.pasta.aglioeolio.config.jpa.User;
import com.pasta.aglioeolio.domains.wish.dto.response.WishResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    public String mtNumber;
    public String password;
    public String role;

    public static UserResponse from(){
        return UserResponse.builder()
                .mtNumber("군번")
                .password("비번")
                .build();
    }
    
}
