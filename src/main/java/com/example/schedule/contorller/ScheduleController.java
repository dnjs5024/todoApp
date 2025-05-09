package com.example.schedule.contorller;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveRequestDto;
import com.example.schedule.dto.schedule.ScheduleSaveResponseDto;
import com.example.schedule.dto.schedule.ScheduleUpdateRequestDto;
import com.example.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 저장
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/v1/schedule")
    public ResponseEntity<ScheduleSaveResponseDto> save(
            @RequestBody @Valid ScheduleSaveRequestDto requestDto) {
        return scheduleService.save(requestDto);
    }

    /**
     * 일정 전체 조회 컨트롤러
     *
     * @return
     */
    @GetMapping("/v1/schedules")
    public ResponseEntity<List<ScheduleFindResponseDto>> findAll() {
        return scheduleService.findAll();
    }

    /**
     * 페이징으로 스케줄 가져옴
     * @param  page  기본값 0
     * @param size 기본값 10 최소 1이상
     * @return 페이징 범위의 일정들
     */
    @GetMapping("/v2/schedules")
    public ResponseEntity<List<ScheduleFindResponseDto>> findByPage(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") @Min(value = 1) int size
    ) {
        return scheduleService.findByPage(size,page);
    }

    /**
     * 선택 일정 삭제 컨트롤러
     *
     * @param scheduleId
     */
    @DeleteMapping("/v1/schedule/{scheduleId}")
    public void delete(
            @PathVariable @Min(value = 1, message = "1이상 값을 넣어주셈") long scheduleId) {
        scheduleService.delete(scheduleId);
    }

    /**
     * 선택한 일정 업데이트
     *
     * @param scheduleId 일정아이디
     * @param requestDto 수정 내용, 수정 제목 받음
     * @return
     */
    @PatchMapping("/v1/schedule/{scheduleId}")
    public ResponseEntity<String> update(
            @PathVariable @Min(value = 1, message = "1이상 값을 넣어주셈") long scheduleId,
            @RequestBody @Valid ScheduleUpdateRequestDto requestDto
    ) {
        return scheduleService.update(requestDto, scheduleId);
    }

}
