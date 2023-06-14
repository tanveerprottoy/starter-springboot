package com.github.tanveerprottoy.starterspringboot.components;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

public class ResponseHelper<T> {

    ResponseEntity<T> Respond(@Nullable T body, HttpStatusCode status) {
        return new ResponseEntity<T>(body, status);
    }

    ResponseEntity<T> Respond(@Nullable T body, @Nullable MultiValueMap<String, String> headers,
            HttpStatusCode status) {
        return new ResponseEntity<T>(body, headers, status);
    }
}
