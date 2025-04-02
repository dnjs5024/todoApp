package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateResponseDto {

    private final String userName;

    private final String userEmail;

    public UserUpdateResponseDto(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

}
