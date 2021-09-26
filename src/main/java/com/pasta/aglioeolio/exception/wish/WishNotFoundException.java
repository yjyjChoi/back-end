package com.pasta.aglioeolio.exception.wish;

import com.pasta.aglioeolio.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class WishNotFoundException extends ApplicationException {

    private static final String CODE = "A0001";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
    private static final String MESSAGE = "해당 소원이 존재하지 않습니다.";

    public WishNotFoundException() {
        this(CODE, HTTP_STATUS, MESSAGE);
    }

    private WishNotFoundException(
        String errorCode,
        HttpStatus httpStatus,
        String message
    ) {
        super(errorCode, httpStatus, message);
    }
}