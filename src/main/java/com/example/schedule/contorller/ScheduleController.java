package com.example.schedule.contorller;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveRequestDto;
import com.example.schedule.dto.schedule.ScheduleSaveResponseDto;
import com.example.schedule.dto.schedule.ScheduleUpdateRequestDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     * 저장
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/v1/schedule")
    public ResponseEntity<ScheduleSaveResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto) {
        return scheduleService.save(requestDto);
    }

    @GetMapping("/v1/schedule")
    public ResponseEntity<List<ScheduleFindResponseDto>> findAll() {
        return scheduleService.findAll();
    }

    /**
     * 삭제
     *
     * @param scheduleId
     */
    @DeleteMapping("/v1/schedule/{scheduleId}")
    public void delete(@PathVariable long scheduleId) {
        scheduleService.delete(scheduleId);
    }

    @PatchMapping("/v1/schedule/{scheduleId}")
    public ResponseEntity<String> update(
            @PathVariable long scheduleId,
            @RequestBody ScheduleUpdateRequestDto requestDto
    ) {
        return scheduleService.updateSchedule(requestDto, scheduleId);
    }

}
