package com.pasta.aglioeolio.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {

    private static final LoginUser ANONYMOUS = new LoginUser();

    private Long id;

    public static LoginUser anonymous() {
        return ANONYMOUS;
    }

}