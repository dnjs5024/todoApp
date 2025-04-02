package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleSaveResponseDto {

    private final Long userId;

    private final String scheduleTitle;

    private final String scheduleContent;

    public ScheduleSaveResponseDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.userId = userId;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }

}
