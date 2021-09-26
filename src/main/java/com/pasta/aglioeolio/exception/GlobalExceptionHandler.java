package com.pasta.aglioeolio.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_FORMAT = "Class : {}, Code : {}, Message : {}";
    private static final String INTERNAL_SERVER_ERROR_CODE = "S0001";

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(ApplicationException ex) {
        String errorCode = ex.getErrorCode();
        log.warn(
            LOG_FORMAT,
            ex.getClass().getSimpleName(),
            errorCode,
            ex.getMessage()
        );
        return ResponseEntity
            .status(ex.getHttpStatus())
            .body(new ExceptionResponse(errorCode));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException e) {
        log.error(
            LOG_FORMAT,
            e.getClass().getSimpleName(),
            INTERNAL_SERVER_ERROR_CODE,
            e.getMessage()
        );
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ExceptionResponse(INTERNAL_SERVER_ERROR_CODE));
    }

}