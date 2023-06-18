package com.github.tanveerprottoy.starterspringboot.modules.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class UserDto {
    private String firstName;
    private String lastName;
}