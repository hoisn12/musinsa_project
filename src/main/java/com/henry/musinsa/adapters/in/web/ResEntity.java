package com.henry.musinsa.adapters.in.web;


import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResEntity {

    public static <T> ResponseEntity<?> success() {
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", "0000");
        returnMap.put("message", "success");

        return ResponseEntity.status(HttpStatus.OK).body(returnMap);
    }

    public static <T> ResponseEntity<?> success(T t) {
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }


    public static <T> ResponseEntity<?> fail(T t) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t);
    }

    public static <T> ResponseEntity<?> error(T t) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
    }

    public static <T> ResponseEntity<?> error(T a, T b) {
        HashMap<String, T> returnMap = new HashMap<>();
        returnMap.put("code", a);
        returnMap.put("message", b);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(returnMap);
    }

    public static <T> ResponseEntity<?> error(HttpStatus httpStatus, T c, T t) {
        HashMap<String, T> returnMap = new HashMap<>();
        returnMap.put("code", c);
        returnMap.put("message", t);

        return ResponseEntity.status(httpStatus).body(returnMap);
    }
}