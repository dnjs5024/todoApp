package com.example.schedule.dto.comment;

import lombok.Getter;

@Getter
public class commentFindRequestDto {

    private final Long userId;


    private final String content;

    public commentFindRequestDto(Long userId, String scheduleContent) {
        this.userId = userId;
        this.content = scheduleContent;
    }
}
