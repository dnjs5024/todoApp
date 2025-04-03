package com.example.schedule.dto.schedule;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleFindResponseDto {

    private final Long userId;

    private final String title;

    private final String content;

    public ScheduleFindResponseDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.userId = userId;
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }

    public static List<ScheduleFindResponseDto> toDto(List<Schedule> schedule) {
        List<ScheduleFindResponseDto> resultList = new ArrayList<>();
        for (Schedule item : schedule) {
            resultList.add(new ScheduleFindResponseDto(item.getId(), item.getTitle(), item.getContent()));
        }
        return resultList;
    }

}
