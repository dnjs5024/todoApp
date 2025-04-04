package com.example.schedule.serviceimpl;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveResponseDto;
import com.example.schedule.dto.schedule.ScheduleSaveRequestDto;
import com.example.schedule.dto.schedule.ScheduleUpdateRequestDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


    /**
     * 일정 저장하는 메소드
     *
     * @param requestDto 일정 제목, 내용 ,작성한 유저 아이디 받음
     * @return 저장한 일정 아이디 , 제목 , 내용 상태코드와 같이 반환
     */
    @Override
    public ResponseEntity<ScheduleSaveResponseDto> save(ScheduleSaveRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(requestDto.getId());

        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getContent(), user);//user 테이블과 관계 설정
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
     *
     * @param scheduleId 일정 id
     */
    @Override
    public void delete(Long scheduleId) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        scheduleRepository.delete(schedule);

    }

    /**
     * 모든 일정조회해주는 메소드
     *
     * @return 쿼리 조회 결과를 List에 담아서 상태코드와 같이 리턴
     */
    @Override
    public ResponseEntity<List<ScheduleFindResponseDto>> findAll() {
        return new ResponseEntity<>(ScheduleFindResponseDto.toDto(scheduleRepository.findAll()), HttpStatus.OK);
    }


    /**
     * 일정 아이디 받아서 수정해주는 메소드
     *
     * @param requestDto 내용, 제목 받음
     * @param scheduleId 일정 아이디
     * @return 상태코드 200 리턴
     */
    @Transactional
    @Override
    public ResponseEntity<String> update(ScheduleUpdateRequestDto requestDto, long scheduleId) {


        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        schedule.setContent(requestDto.getContent());
        schedule.setTitle(requestDto.getTitle());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 페이징으로 범위 조회
     *
     * @param size 페이지 크기 기본값 10
     * @param page 현제 페이지
     * @return 할일 제목, 할일 내용, 댓글 개수, 일정 작성일, 일정 수정일, 일정 작성 유저명 담은 dto
     */
    @Override
    public ResponseEntity<List<ScheduleFindResponseDto>> findByPage(int size, int page) {
        //페이징 수정일 기준 내림차순 정렬
        Page<Schedule> pageList = scheduleRepository.findAll(PageRequest.of(page, size, Sort.by("updatedAt").descending()));


        return new ResponseEntity<>(ScheduleFindResponseDto.toDto(pageList.getContent()), HttpStatus.OK);
    }
}
