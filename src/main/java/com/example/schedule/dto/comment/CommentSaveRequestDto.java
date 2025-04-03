package com.example.schedule.dto.comment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    @Min(value = 1, message = "1이상 값 넣어주셈")
    private final Long userId;

    @NotBlank
    @Size(max = 100, message = "내용은 0 - 100글자 사이로 작성")
    private final String content;

    public CommentSaveRequestDto(Long userId, String scheduleContent) {
        this.userId = userId;
        this.content = scheduleContent;
    }
}
