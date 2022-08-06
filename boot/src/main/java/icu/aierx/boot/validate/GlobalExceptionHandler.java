package icu.aierx.boot.validate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
  * @ClassName: GlobalExceptionHandler
  * @Description: 全局异常处理器
  */
//@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public TRsult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("{}", e.getBindingResult().getFieldError().getDefaultMessage());
        return new TRsult("200");
    }
}