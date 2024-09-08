package org.example.msorder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorConstants {
    USER_NOTFOUND_ERROR("User Not Found", "USER_NOT_FOUND"),
    NOTFOUND_ERROR("Order Not Found", "ORDER_NOT_FOUND"),
    CLIENT_ERROR("Client Error", "CLIENT_ERROR"),
    UNEXPECTED_ERROR("Unexpected Exception", "UNEXPECTED_EXCEPTION");

    private final String message;
    private final String code;
}
