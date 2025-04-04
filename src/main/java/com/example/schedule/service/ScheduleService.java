package com.example.schedule.service;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveRequestDto;
import com.example.schedule.dto.schedule.ScheduleUpdateRequestDto;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {

    public ResponseEntity<ScheduleSaveResponseDto> save(ScheduleSaveRequestDto requestDto);

    //일정 삭제 메소드
    public void delete(Long scheduleId);

    //조회
    ResponseEntity<List<ScheduleFindResponseDto>> findAll();

    //업데이트
    ResponseEntity<String> update(ScheduleUpdateRequestDto requestDto, long scheduleId);

    ResponseEntity<List<ScheduleFindResponseDto>> findByPage(int size, @Min(value = 1) int page);
}
