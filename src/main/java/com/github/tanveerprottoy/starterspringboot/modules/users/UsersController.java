package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.modules.users.dto.UserDto;
import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;
import com.github.tanveerprottoy.starterspringboot.utils.AdapterUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${v1}/users")
public class UsersController {

    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @PostMapping
    public @ResponseBody User create(@RequestBody UserDto dto) {
        return this.service.create(dto);
    }

    @GetMapping
    public @ResponseBody Page<User> readAll(
        @RequestParam(value = "page", defaultValue = "1") String page,
        @RequestParam(value = "limit", defaultValue = "10") String limit
    ) {
        int pageNumeric = AdapterUtils.stringToInt(page);
        int limitNumeric = AdapterUtils.stringToInt(limit);
        return this.service.readAll(pageNumeric, limitNumeric);
    }

    @GetMapping("/{id}")
    public @ResponseBody User readOne(@PathVariable(value = "id") String id) {
        long idNumeric = AdapterUtils.stringToLong(id);
        return this.service.readOne(idNumeric);
    }

    @PostMapping("/{id}")
    public @ResponseBody User update(
        @PathVariable(value = "id") String id,
        @RequestBody UserDto dto
    ) {
        long idNumeric = AdapterUtils.stringToLong(id);
        return this.service.update(idNumeric, dto);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody long delete(@PathVariable(value = "id") String id) {
        long idNumeric = AdapterUtils.stringToLong(id);
        return this.service.delete(idNumeric);
    }
}
