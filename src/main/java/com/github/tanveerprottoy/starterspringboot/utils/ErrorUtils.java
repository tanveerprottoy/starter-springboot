package com.github.tanveerprottoy.starterspringboot.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorUtils {

    public static ResponseStatusException throwError(String message) throws Error {
        throw new Error(message);
    }

    public static ResponseStatusException throwHttpError(
        HttpStatus status,
        String reason
    ) throws ResponseStatusException {
        throw new ResponseStatusException(
            status,
            reason
        );
    }

    public static ResponseStatusException throwHttpError(
        HttpStatus status,
        String reason,
        Throwable throwable
    ) throws ResponseStatusException {
        throw new ResponseStatusException(
            status,
            reason,
            throwable
        );
    }
}
