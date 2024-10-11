package com.henry.musinsa.infrastructure.config;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS("0000", "Success"),
    INVALID_INPUT_VALUE("1001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED("1002", "method not allowed"),
    INVALID_PATH_PARAM("1003", "invalid path param"),
    INTERNAL_SERVER_ERROR("9999", "internal server error");

    private final String code;
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
