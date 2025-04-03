package com.example.schedule.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserSignInResponseDto {

    private final Long id;

    private final String name;

    private final String email;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

}
