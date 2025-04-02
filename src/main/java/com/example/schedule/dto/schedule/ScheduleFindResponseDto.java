package com.example.schedule.dto.schedule;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleFindResponseDto {

    private final Long userId;

    private final String scheduleTitle;

    private final String scheduleContent;

    public ScheduleFindResponseDto(Long userId, String scheduleTitle, String scheduleContent) {
        this.userId = userId;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
    }

    public static List<ScheduleFindResponseDto> toDto(List<Schedule> schedule) {
        List<ScheduleFindResponseDto> resultList = new ArrayList<>();
        for (Schedule item : schedule) {
            resultList.add(new ScheduleFindResponseDto(item.getId(), item.getTitle(), item.getContent()));
        }
        return resultList;
    }

}
