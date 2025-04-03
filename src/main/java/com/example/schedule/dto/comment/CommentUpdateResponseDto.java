package com.example.schedule.dto.comment;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {

    private final String title;

    private final String content;

    public CommentUpdateResponseDto(String scheduleTitle, String scheduleContent) {
        this.title = scheduleTitle;
        this.content = scheduleContent;
    }

}
