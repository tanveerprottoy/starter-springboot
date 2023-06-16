package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.components.dtos.response.user.UsersResponse;
import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;

import org.springframework.stereotype.Service;

@Service
public class UsersRepository {
    
    public UsersResponse<User> readAll(
        String limit,
        String page
    ) {
        return null;
    }
}
