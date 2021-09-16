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
    private Integer status; // HTTP 상태값
    private String message = "";
    @Builder.Default
    private List<Map<String, String>> fieldErrors = new ArrayList<>();

    ExceptionResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    ExceptionResponse(Integer status, String message, List<Map<String, String>> fieldErrors) {
        this.status = status;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

    public void addFieldError(Map<String, String> map){
        fieldErrors.add(map);
    }

}