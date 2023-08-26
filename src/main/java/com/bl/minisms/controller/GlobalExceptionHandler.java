package com.bl.minisms.controller;

import com.bl.minisms.model.dto.ResponseData;
import com.bl.minisms.model.exceptions.InvalidArgumentException;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private static String TITLE = "Global Exception Info ";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<String> unknownException(Exception e){
        logger.error(TITLE,e.getMessage(),e);
        return ResponseData.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, InvalidArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData<String> validationException(Exception e){
        logger.error(TITLE,e.getMessage(),e);
        return ResponseData.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}

