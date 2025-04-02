package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {

    private final String scheduleTitle;

    private final String scheduleContent;

    public ScheduleUpdateResponseDto(String scheduleTitle, String scheduleContent) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }

}
