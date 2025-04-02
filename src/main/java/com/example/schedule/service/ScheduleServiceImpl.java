package com.example.schedule.service;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveRequestDto;
import com.example.schedule.dto.schedule.ScheduleUpdateRequestDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ScheduleSaveResponseDto> save(ScheduleSaveRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(requestDto.getUserId());

        Schedule schedule = new Schedule(requestDto.getScheduleTitle(), requestDto.getScheduleContent(), user);
        Schedule saveData = scheduleRepository.save(schedule);
        return new ResponseEntity<>(
                new ScheduleSaveResponseDto(
                        saveData.getId(),
                        saveData.getTitle(),
                        saveData.getContent())
                , HttpStatus.CREATED);
    }

    /**
     * 일정 삭제 메소드
     * @param scheduleId
     */
    @Override
    public void delete(Long scheduleId) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        scheduleRepository.delete(schedule);

    }

    @Override
    public ResponseEntity<List<ScheduleFindResponseDto>> findAll() {
        return new ResponseEntity<>(ScheduleFindResponseDto.toDto(scheduleRepository.findAll()),HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity<String> updateSchedule(ScheduleUpdateRequestDto requestDto, long scheduleId) {

        //영속성
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        schedule.setContent(requestDto.getScheduleContent());
        schedule.setTitle(requestDto.getScheduleTitle());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
