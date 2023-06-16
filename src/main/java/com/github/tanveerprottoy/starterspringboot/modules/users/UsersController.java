package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.components.dtos.response.user.UsersResponse;
import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${v1}/users")
public class UsersController {

    private final UsersService service;

    UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public @ResponseBody UsersResponse<User> readAll(
        @RequestParam(value = "limit", defaultValue = "10") String limit,
        @RequestParam(value = "page", defaultValue = "1") String page
    ) {
        return this.service.readAll(limit, page);
    }
}
