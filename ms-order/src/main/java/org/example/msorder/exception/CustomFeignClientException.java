package org.example.msorder.exception;

import lombok.Getter;

@Getter

public class CustomFeignClientException extends RuntimeException {
    private final int status;
    private final String code;
   public CustomFeignClientException(final String message, final String code, final int status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
