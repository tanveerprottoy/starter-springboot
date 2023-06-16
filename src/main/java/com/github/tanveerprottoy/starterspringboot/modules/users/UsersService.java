package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.components.dtos.response.user.UsersResponse;
import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;
import com.github.tanveerprottoy.starterspringboot.utils.AdapterUtils;

import org.springframework.stereotype.Service;

@Service
public class UsersService {
    
    public UsersResponse<User> readAll(
        String limit,
        String page
    ) {
        User user = new User("john", "dow");
        UsersResponse<User> response = new UsersResponse<>();
        response.setLimit(AdapterUtils.stringToInt(limit));
        response.setPage(AdapterUtils.stringToInt(page));
        response.setData(user);
        return response;
    }
}
