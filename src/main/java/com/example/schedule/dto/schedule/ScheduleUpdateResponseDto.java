package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {

    private final String title;

    private final String content;

    public ScheduleUpdateResponseDto(String scheduleTitle, String scheduleContent) {
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }

}
