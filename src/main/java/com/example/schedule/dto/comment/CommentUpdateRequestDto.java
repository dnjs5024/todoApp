package com.example.schedule.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentUpdateRequestDto {


    @NotBlank
    @Size(max = 30 ,message = "내용은 0 - 30글자 사이로 작성")
    private final String content;

}
