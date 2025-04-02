package com.example.schedule.contorller;

import com.example.schedule.dto.schedule.ScheduleFindResponseDto;
import com.example.schedule.dto.user.UserFindResponseDto;
import com.example.schedule.dto.user.UserSignUpRequestDto;
import com.example.schedule.dto.user.UserSignUpResponseDto;
import com.example.schedule.dto.user.UserUpdateRequestDto;
import com.example.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    /**
     * 회원정보등록
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/v1/user")
    public ResponseEntity<UserSignUpResponseDto> save(@RequestBody UserSignUpRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PatchMapping("/v1/user/{id}")
    public ResponseEntity<String> updateUser(
            @RequestBody UserUpdateRequestDto requestDto,
            @PathVariable long id
    ) {
        return userService.updateUser(requestDto,id);
    }

    @GetMapping("/v1/user")
    public ResponseEntity<List<UserFindResponseDto>> findAll() {
        return userService.findAll();
    }

    /**
     * 삭제
     *
     * @param id
     */
    @DeleteMapping("/v1/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }

}
