package com.pasta.aglioeolio.exception.wish;

import com.pasta.aglioeolio.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class WishReadByOfficerException extends ApplicationException {

    private static final String CODE = "A0002";
    private static final HttpStatus HTTP_STATUS = HttpStatus.LOCKED;
    private static final String MESSAGE = "간부가 소원을 읽었습니다.";

    public WishReadByOfficerException() {
        this(CODE, HTTP_STATUS, MESSAGE);
    }

    private WishReadByOfficerException(
        String errorCode,
        HttpStatus httpStatus,
        String message
    ) {
        super(errorCode, httpStatus, message);
    }

}