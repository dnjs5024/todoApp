package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UserSignUpResponseDto {

    private final String userName;

    private final String userEmail;

    public UserSignUpResponseDto(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }


}
