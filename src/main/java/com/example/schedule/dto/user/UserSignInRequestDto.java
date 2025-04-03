package com.example.schedule.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSignInRequestDto {

    private final String name;

    private final String email;

    private final String password;


}
