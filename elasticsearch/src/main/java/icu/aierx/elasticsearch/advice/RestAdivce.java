package icu.aierx.elasticsearch.advice;

import icu.aierx.elasticsearch.base.CommonResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */

@RestControllerAdvice
public class RestAdivce {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult handlerValid(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        return CommonResult.SUCCESS(fieldError.getField() + " " + fieldError.getDefaultMessage());
    }

}
