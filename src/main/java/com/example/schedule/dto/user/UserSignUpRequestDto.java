package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    private final String userName;

    private final String userEmail;

    public UserSignUpRequestDto(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

}
