package com.example.schedule.dto.user;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserFindResponseDto {

    private final String name;

    private final String email;

    private final Long id;

    public static List<UserFindResponseDto> toDto(List<User> user) {
        List<UserFindResponseDto> resultList = new ArrayList<>();
        for (User item : user) {
            resultList.add(new UserFindResponseDto(item.getName(), item.getEmail(), item.getId()));
        }
        return resultList;
    }
}
