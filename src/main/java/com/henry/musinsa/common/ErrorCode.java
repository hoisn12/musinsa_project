package com.henry.musinsa.common;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS("0000", "Success"),
    INVALID_INPUT_VALUE("1001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED("1002", "method not allowed"),
    INVALID_PATH_PARAM("1003", "invalid path param"),
    URL_NOT_FOUND("1004", "url not found"),
    DATE_FORMAT_MISMATCH("1005", "date format mismatch"),
    INTERNAL_SERVER_ERROR("9999", "internal server error"),

    CREATE_BRAND_DATA_EMPTY("2000", "create brand data body empty"),
    BRAND_NOT_FOUND("2001", "brand not found"),

    CREATE_PRODUCT_DATA_EMPTY("3000", "create product data body empty"),
    PRODUCT_NOT_FOUND("3001", "product not found"),

    PRODUCT_CATEGORY_NOT_FOUND("4001", "product category not found");


    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
