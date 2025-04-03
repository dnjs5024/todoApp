package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleFindRequestDto {

    private final Long userId;

    private final String title;

    private final String content;

    public ScheduleFindRequestDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.userId = userId;
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }
}
