package com.example.schedule.dto.user;

import com.example.schedule.entity.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserUpdateRequestDto {

    private final String name;

    private final String email;

    public UserUpdateRequestDto(String userName, String userEmail) {
        this.name = userName;
        this.email = userEmail;
    }

}
