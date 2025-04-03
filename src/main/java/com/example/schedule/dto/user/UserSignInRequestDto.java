package com.example.schedule.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSignInRequestDto {

    @NotBlank
    private final String email;

    @NotBlank
    private final String password;


}
