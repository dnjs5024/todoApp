package com.example.schedule.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentSaveResponseDto {

    private final Long id;

    private final Long userId;

    private final Long scheduleId;

    private final String content;

    private final LocalDateTime CreatedAt;

    private final LocalDateTime updatedAt;

}
