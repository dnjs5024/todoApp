package com.example.schedule.service;

import com.example.schedule.dto.user.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<UserSignUpResponseDto> save(UserSignUpRequestDto requestDto);

    ResponseEntity<String> update(UserUpdateRequestDto requestDto, long id);

    ResponseEntity<List<UserFindResponseDto>> findAll();

    void delete(long id);

    UserSignInResponseDto login(String email,String password);

    boolean isEmail(String email);
}
