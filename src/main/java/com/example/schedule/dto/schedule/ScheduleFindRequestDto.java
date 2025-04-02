package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleFindRequestDto {

    private final Long userId;

    private final String scheduleTitle;

    private final String scheduleContent;

    public ScheduleFindRequestDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.userId = userId;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }
}
