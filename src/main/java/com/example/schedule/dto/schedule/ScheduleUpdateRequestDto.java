package com.example.schedule.dto.schedule;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    @NotBlank
    @Size(max = 10 ,message = "제목은 0 - 10글자 사이로 작성")
    private final String title;

    @NotBlank
    @Size(max = 100 ,message = "내용은 0 - 100글자 사이로 작성")
    private final String content;

    public ScheduleUpdateRequestDto(String scheduleTitle, String scheduleContent) {
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }
}
