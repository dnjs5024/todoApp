package com.example.schedule.dto.user;

import com.example.schedule.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
public class UserUpdateRequestDto {

    @NotBlank
    @Size(max = 5, message = "이름은 5글자 이하")
    private final String name;

    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "올바른 이메일 형식"
    )
    private final String email;

    public UserUpdateRequestDto(String userName, String userEmail) {
        this.name = userName;
        this.email = userEmail;
    }

}
