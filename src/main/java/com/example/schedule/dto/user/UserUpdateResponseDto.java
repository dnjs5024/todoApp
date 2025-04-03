package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateResponseDto {

    private final String name;

    private final String email;

    public UserUpdateResponseDto(String userName, String userEmail) {
        this.name = userName;
        this.email = userEmail;
    }

}
