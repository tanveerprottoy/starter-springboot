package com.github.tanveerprottoy.starterspringboot.components.dtos.response.user;

import com.github.tanveerprottoy.starterspringboot.components.dtos.response.BaseResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class UsersResponse<T> extends BaseResponse<T> {
    private int limit;
    private int page;
}