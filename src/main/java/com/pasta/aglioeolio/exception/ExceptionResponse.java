package com.pasta.aglioeolio.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ExceptionResponse {
    private String errorCode;
    @Builder.Default
    private List<Map<String, String>> fieldErrors = new ArrayList<>();

    public ExceptionResponse(String errorCode) {
        this.errorCode = errorCode;
    }

    public ExceptionResponse(String errorCode,
        List<Map<String, String>> fieldErrors) {
        this.errorCode = errorCode;
        this.fieldErrors = fieldErrors;
    }

    public void addFieldError(Map<String, String> map){
        fieldErrors.add(map);
    }

}