package org.example.msorder.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.example.msorder.exception.ErrorConstants.UNEXPECTED_ERROR;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception ex) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(400))
                .body(ErrorResponse.builder()
                        .code(UNEXPECTED_ERROR.getCode())
                        .message(UNEXPECTED_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(final NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(404))
                .body(ErrorResponse.builder()
                        .code(ex.getCode())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(CustomFeignClientException.class)
    public ResponseEntity<ErrorResponse> handleCustomFeignClientException(final CustomFeignClientException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorResponse.builder()
                        .code(ex.getCode())
                        .message(ex.getMessage())
                        .build());
    }
}
