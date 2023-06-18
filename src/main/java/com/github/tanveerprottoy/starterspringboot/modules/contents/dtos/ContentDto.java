package com.github.tanveerprottoy.starterspringboot.modules.contents.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class ContentDto {
    private String title;
    private String detail;
}