package dev.jav.foro.infra.error;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        String message,
        boolean success,
        HttpStatus status
) {
}
