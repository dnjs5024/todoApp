package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private final String title;

    private final String content;

    public ScheduleUpdateRequestDto(String scheduleTitle, String scheduleContent) {
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }
}
