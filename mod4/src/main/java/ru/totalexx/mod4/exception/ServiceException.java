package ru.totalexx.mod4.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException {
    private final HttpStatus status;

    public ServiceException(HttpStatus statusCode) {
        this.status = statusCode;
        HttpStatus accepted = HttpStatus.ACCEPTED;
    }

    public ServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public ServiceException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }
}
