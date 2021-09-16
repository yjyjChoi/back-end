package com.pasta.aglioeolio.exception;

import com.pasta.aglioeolio.exception.sub.BadReqeustException;
import com.pasta.aglioeolio.exception.sub.CustomException;
import com.pasta.aglioeolio.exception.sub.InternalServerException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ExceptionMessage {
    // 서버 에러 : 5xx
    INTERNAL_SERVER(new InternalServerException("서버 에러입니다. 서버 관리자에게 문의주세요.")),

    // Client 오류 : 4xx
    INVALID_ARGUMENT(new BadReqeustException("입력값이 올바르지 않습니다."));


    private CustomException exception;

}