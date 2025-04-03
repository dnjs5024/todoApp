package com.example.schedule.contorller;

import com.example.schedule.dto.comment.CommentFindResponseDto;
import com.example.schedule.dto.comment.CommentSaveRequestDto;
import com.example.schedule.dto.comment.CommentSaveResponseDto;
import com.example.schedule.dto.comment.CommentUpdateRequestDto;
import com.example.schedule.service.CommentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 저장
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/v1/comment/{scheduleId}")
    public ResponseEntity<CommentSaveResponseDto> save(
            @RequestBody @Valid CommentSaveRequestDto requestDto,
            @PathVariable @Min(value = 1, message = "1이상 값을 넣어주셈")  long scheduleId
    ) {
        return commentService.save(requestDto,scheduleId);
    }

    /**
     * 일정 전체 조회 컨트롤러
     *
     * @return
     */
    @GetMapping("/v1/comment")
    public ResponseEntity<List<CommentFindResponseDto>> findAll() {
        return commentService.findAll();
    }

    /**
     * 선택 일정 삭제 컨트롤러
     *
     * @param commentId
     */
    @DeleteMapping("/v1/comment/{commentId}")
    public void delete(
            @PathVariable @Min(value = 1, message = "1이상 값을 넣어주셈") long commentId) {
        commentService.delete(commentId);
    }

    /**
     * 선택한 일정 업데이트
     *
     * @param commentId 일정아이디
     * @param requestDto 수정 내용, 수정 제목 받음
     * @return
     */
    @PatchMapping("/v1/comment/{commentId}")
    public ResponseEntity<String> update(
            @PathVariable @Min(value = 1, message = "1이상 값을 넣어주셈") long commentId,
            @RequestBody @Valid CommentUpdateRequestDto requestDto
    ) {
        return commentService.update(requestDto, commentId);
    }

}
