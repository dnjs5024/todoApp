package com.example.schedule.service;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.user.UserFindResponseDto;
import com.example.schedule.dto.user.UserSignUpRequestDto;
import com.example.schedule.dto.user.UserSignUpResponseDto;
import com.example.schedule.dto.user.UserUpdateRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<UserSignUpResponseDto> save(UserSignUpRequestDto requestDto);

    ResponseEntity<String> updateUser(UserUpdateRequestDto requestDto, long id);

    ResponseEntity<List<UserFindResponseDto>> findAll();

    void delete(long id);
}
