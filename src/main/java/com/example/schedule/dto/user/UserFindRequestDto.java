package com.example.schedule.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserFindRequestDto {

    private final String userName;

    private final String userEmail;

    private final Long userId;



}
