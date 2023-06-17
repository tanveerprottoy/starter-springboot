package com.github.tanveerprottoy.starterspringboot.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaginationUtils {

    public static Pageable buildPageRequest(int page, int limit) {
        try {
            return PageRequest.of(page, limit);
        }
        catch(Exception e) {
            return null;
        }
    }
}
