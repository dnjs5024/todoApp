package com.example.schedule.service;

import com.example.schedule.dto.comment.CommentFindResponseDto;
import com.example.schedule.dto.comment.CommentSaveRequestDto;
import com.example.schedule.dto.comment.CommentSaveResponseDto;
import com.example.schedule.dto.comment.CommentUpdateRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {

    public ResponseEntity<CommentSaveResponseDto> save(@Valid CommentSaveRequestDto requestDto,Long scheduleId);

    //일정 삭제 메소드
    public void delete(Long commentId);

    //조회
    ResponseEntity<List<CommentFindResponseDto>> findAll();

    //업데이트
    ResponseEntity<String> update(@Valid CommentUpdateRequestDto requestDto, long scheduleId);
}
