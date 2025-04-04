package com.example.schedule.dto.schedule;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleFindResponseDto {

    private final Long userId;

    private final String title;

    private final String content;

    private final int commentCnt;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final String userName;


    public static List<ScheduleFindResponseDto> toDto(List<Schedule> schedule) {
        List<ScheduleFindResponseDto> resultList = new ArrayList<>();
        for (Schedule item : schedule) {
            resultList.add(new ScheduleFindResponseDto(
                    item.getId(),
                    item.getTitle(),
                    item.getContent(),
                    item.getCommentCnt(),
                    item.getCreatedAt(),
                    item.getUpdatedAt(),
                    item.getUser().getName()
            ));
        }
        return resultList;
    }

}
