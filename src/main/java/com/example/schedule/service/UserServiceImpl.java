package com.example.schedule.service;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.user.*;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * 유저 정보 저장하는 메소드
     * @param requestDto
     * @return 등록한 유저정보와 상태코드 리턴
     */
    @Override
    public ResponseEntity<UserSignUpResponseDto> save(UserSignUpRequestDto requestDto) {

        User user = new User(requestDto.getUserName(),requestDto.getUserEmail());
        User saveData = userRepository.save(user);

        return new ResponseEntity<>(new UserSignUpResponseDto(saveData.getName(),saveData.getEmail()), HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity<String> updateUser(UserUpdateRequestDto requestDto, long id) {

        User user = userRepository.findByIdOrElseThrow(id);//영속성

        user.setEmail(requestDto.getUserEmail());
        user.setName(requestDto.getUserName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserFindResponseDto>> findAll() {
        return new ResponseEntity<>(UserFindResponseDto.toDto(userRepository.findAll()),HttpStatus.OK);
    }

    @Override
    public void delete(long id) {

        userRepository.delete(userRepository.findByIdOrElseThrow(id));

    }
}
