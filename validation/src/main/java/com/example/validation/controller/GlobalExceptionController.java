package com.example.validation.controller;

import com.example.validation.utils.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CJW
 * @since 2023/11/20
 */
@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        System.out.println("dddddddddddddddddddddddddddddddddddddddd");
        Map<String, String> map = new HashMap<>(fieldErrors.size());
        fieldErrors.forEach((fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }));
        return Result.error(map);
    }
}
