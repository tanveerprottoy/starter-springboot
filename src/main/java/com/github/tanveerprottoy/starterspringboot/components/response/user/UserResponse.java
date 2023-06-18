package com.github.tanveerprottoy.starterspringboot.components.response.user;

import com.github.tanveerprottoy.starterspringboot.components.response.BaseResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class UserResponse<T> extends BaseResponse<T> {
    private int limit;
    private int page;
}