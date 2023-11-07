package se.cookBookProv2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import se.cookBookProv2.exceptions.ExceptionManager;
import se.cookBookProv2.exceptions.MyExceptionResponse;
import se.cookBookProv2.exceptions.ValidationErrorResponse;
import se.cookBookProv2.exceptions.Violation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MyControllerAdviser {

    private MyExceptionResponse build(HttpStatus httpStatus, String ex, WebRequest request){
        return new MyExceptionResponse(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.name(),
                ex,
                request.getDescription(false)
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MyExceptionResponse handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(ExceptionManager.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MyExceptionResponse handleResourceNotFoundException(ExceptionManager ex, WebRequest request){
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
        List<Violation> violations = new ArrayList<>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()) {
            violations.add(new Violation(error.getField(), error.getDefaultMessage()));
        }
        return new ValidationErrorResponse(build(HttpStatus.BAD_REQUEST, "One or more validations are incorrect.", request), violations);
    }
}
