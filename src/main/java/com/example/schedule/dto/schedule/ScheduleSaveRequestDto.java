package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {

    private final Long id;

    private final String title;

    private final String content;

    public ScheduleSaveRequestDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.id = userId;
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }
}
