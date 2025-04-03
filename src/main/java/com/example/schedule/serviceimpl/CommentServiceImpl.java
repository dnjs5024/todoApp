package com.example.schedule.serviceimpl;

import com.example.schedule.dto.comment.CommentFindResponseDto;
import com.example.schedule.dto.comment.CommentSaveRequestDto;
import com.example.schedule.dto.comment.CommentSaveResponseDto;
import com.example.schedule.dto.comment.CommentUpdateRequestDto;
import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import com.example.schedule.repository.CommentRepository;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import com.example.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    /**
     * 댓글 저장하는 메소드
     *
     * @param requestDto 댓글 내용 ,작성한 유저 아이디 받음
     * @param scheduleId
     * @return 저장한 댓글 아이디 ,수정일 ,만들날짜 , 내용 상태코드와 같이 반환
     */
    @Override
    public ResponseEntity<CommentSaveResponseDto> save(CommentSaveRequestDto requestDto, Long scheduleId) {

        User user = userRepository.findByIdOrElseThrow(requestDto.getUserId());

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = new Comment(requestDto.getContent(), user, schedule);//user, schedule 테이블과 관계 설정
        Comment saveData = commentRepository.save(comment);
        return new ResponseEntity<>(
                new CommentSaveResponseDto(
                        saveData.getId(),
                        requestDto.getUserId(),
                        scheduleId,
                        saveData.getContent(),
                        saveData.getCreatedAt(),
                        saveData.getUpdatedAt()), HttpStatus.CREATED);
    }

    /**
     * 댓글 삭제 메소드
     *
     * @param commentId 댓긇 id
     */
    @Override
    public void delete(Long commentId) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        commentRepository.delete(comment);

    }

    /**
     * 모든 댓글조회해주는 메소드
     *
     * @return 쿼리 조회 결과를 List에 담아서 상태코드와 같이 리턴
     */
    @Override
    public ResponseEntity<List<CommentFindResponseDto>> findAll() {
        return new ResponseEntity<>(CommentFindResponseDto.toDto(commentRepository.findAll()), HttpStatus.OK);

    }

    /**
     * 댓글 아이디 받아서 수정해주는 메소드
     *
     * @param requestDto 내용 받음
     * @param commentId  댓글 아이디
     * @return 상태코드 200 리턴
     */
    @Transactional
    @Override
    public ResponseEntity<String> update(CommentUpdateRequestDto requestDto, long commentId) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        comment.setContent(requestDto.getContent());//댓글 내용 업데이트

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
