package com.example.schedule.contorller;

import com.example.schedule.dto.user.UserFindResponseDto;
import com.example.schedule.dto.user.UserSignUpRequestDto;
import com.example.schedule.dto.user.UserSignUpResponseDto;
import com.example.schedule.dto.user.UserUpdateRequestDto;
import com.example.schedule.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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
    public ResponseEntity<UserSignUpResponseDto> save(
            @RequestBody @Valid UserSignUpRequestDto requestDto) {
        return userService.save(requestDto);
    }


    @PatchMapping("/v1/user/{id}")
    public ResponseEntity<String> update(
            @RequestBody @Valid UserUpdateRequestDto requestDto,
            @PathVariable @Min(value = 1, message = "1이상 입력") long id
    ) {
        return userService.updateUser(requestDto, id);
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
    public void delete(
            @PathVariable @Min(value = 1, message = "1이상 입력") long id) {
        userService.delete(id);
    }

}
