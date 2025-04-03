package com.example.schedule.dto.comment;

import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CommentFindResponseDto {

    private final Long id;

    private final Long userId;

    private final Long scheduleId;

    private final String content;

    private final LocalDateTime CreatedAt;

    private final LocalDateTime updatedAt;


    public static List<CommentFindResponseDto> toDto(List<Comment> comment) {
        List<CommentFindResponseDto> resultList = new ArrayList<>();
        for (Comment item : comment) {
            resultList.add(new CommentFindResponseDto(
                    item.getId(),
                    item.getUser().getId(),
                    item.getSchedule().getId(),
                    item.getContent(),
                    item.getCreatedAt(),
                    item.getUpdatedAt()));
        }
        return resultList;
    }

}
