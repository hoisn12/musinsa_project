package com.henry.musinsa.common.exception;

import com.henry.musinsa.common.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ApplicationException extends RuntimeException{

    private final ErrorCode errorCode;

    public ApplicationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
