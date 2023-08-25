package com.bl.minisms.controller;

import com.bl.minisms.model.dto.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private static String TITLE = "Global Exception Info ";

    @ExceptionHandler(value = Exception.class)
    public ResponseData<String> handleException(Exception e){
        logger.error(TITLE,e.getMessage(),e);
        return ResponseData.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}

