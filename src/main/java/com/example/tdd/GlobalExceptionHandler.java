package com.example.tdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/*
 * @RestControllerAdvice 和 @ExceptionHandler 機制，來處理全域的例外狀況的類別。
 * @RestControllerAdvice:表示這是一個用於所有 @RestController 類別的全域性例外狀況處理器。
 * */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*
     * @ResponseStatus(HttpStatus.NOT_FOUND): 標註這個方法處理例外狀況時，回傳的 HTTP 狀態碼是 404 (NOT_FOUND)。
     * */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    /*
     * @ExceptionHandler(QueryNoApprovalFormFoundException.class): 這個標註表示這個方法處理 QueryNoApprovalFormFoundException 這個特定型別的例外狀況。
     * */
    @ExceptionHandler(QueryNoApprovalFormFoundException.class)
    protected Map<String, String> handleQueryNoApprovalFormFoundException(QueryNoApprovalFormFoundException e) {
        log.error("handleQueryNoApprovalFormFoundException", e);
        // Map.of("key1", value1, "key2", value2)
        return Map.of("status", "F", "msg", "查無簽審單");
    }
}
