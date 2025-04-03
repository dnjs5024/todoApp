package com.example.schedule.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSignUpRequestDto {//회원가입 dto

    @NotBlank
    @Size(max = 5, message = "이름은 5글자 이하")
    private final String name;

    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "올바른 이메일 형식"
    )
    private final String email;

    @NotBlank
    @Size(max = 10, message = "비번은 10글자 이하")
    private final String password;


}
