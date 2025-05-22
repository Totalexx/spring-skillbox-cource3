package ru.totalexx.mod4.exception;

import org.springframework.http.HttpStatus;

public class SecurityServiceException extends ServiceException {
    private static final HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;

    public SecurityServiceException() {
        super(unauthorized);
    }

    public SecurityServiceException(String message) {
        super(unauthorized, message);
    }

    public SecurityServiceException(String message, Throwable cause) {
        super(unauthorized, message, cause);
    }
}
