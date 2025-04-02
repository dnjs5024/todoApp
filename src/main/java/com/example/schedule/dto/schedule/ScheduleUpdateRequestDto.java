package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private final String scheduleTitle;

    private final String scheduleContent;

    public ScheduleUpdateRequestDto(String scheduleTitle, String scheduleContent) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }
}
