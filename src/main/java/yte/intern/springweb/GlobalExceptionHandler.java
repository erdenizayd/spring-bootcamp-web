package yte.intern.springweb;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public List<String> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        return exception.getFieldErrors().stream().map(field -> field.getDefaultMessage()).toList();
    }

}
