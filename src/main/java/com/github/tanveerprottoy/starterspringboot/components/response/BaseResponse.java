package com.github.tanveerprottoy.starterspringboot.components.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
public abstract class BaseResponse<T> {
    private @NonNull T data;
}