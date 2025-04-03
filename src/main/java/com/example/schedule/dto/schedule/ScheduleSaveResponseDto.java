package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleSaveResponseDto {

    private final Long id;

    private final String title;

    private final String content;

    public ScheduleSaveResponseDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.id = userId;
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }

}
