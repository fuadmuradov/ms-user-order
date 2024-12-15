package org.example.msuser.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.example.msuser.exception.ErrorConstants.UNEXPECTED_EXCEPTION;

@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(Exception e) {
        return ErrorResponse.builder()
                .message(UNEXPECTED_EXCEPTION.getMessage())
                .code(UNEXPECTED_EXCEPTION.getCode())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(NotFoundException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .code(e.getCode())
                .build();
    }
}
