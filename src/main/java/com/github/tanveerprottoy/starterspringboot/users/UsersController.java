package com.github.tanveerprottoy.starterspringboot.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("users")
    public String readAll(
        @RequestParam(value = "limit", defaultValue = "10") String limit,
        @RequestParam(value = "page", defaultValue = "1") String page
    ) {
        return "hello";
    }
}
