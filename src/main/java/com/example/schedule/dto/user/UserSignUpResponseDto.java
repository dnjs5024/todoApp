package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UserSignUpResponseDto {

    private final String name;

    private final String email;

    public UserSignUpResponseDto(String userName, String userEmail) {
        this.name = userName;
        this.email = userEmail;
    }


}
