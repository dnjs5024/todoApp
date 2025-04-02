package com.example.schedule.dto.user;

import com.example.schedule.entity.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserUpdateRequestDto {

    private final String userName;

    private final String userEmail;

    public UserUpdateRequestDto(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

}
