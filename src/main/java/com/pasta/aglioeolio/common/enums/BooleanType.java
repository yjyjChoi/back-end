package com.pasta.aglioeolio.common.enums;

import lombok.Getter;

@Getter
public enum BooleanType {
    TRUE(true),
    FALSE(false);

    private Boolean status;

    BooleanType(Boolean status) {
        this.status = status;
    }

}