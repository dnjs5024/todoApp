package com.example.schedule.contorller;


import com.example.schedule.dto.user.UserSignInRequestDto;
import com.example.schedule.dto.user.UserSignInResponseDto;
import com.example.schedule.myconst.Const;
import com.example.schedule.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserLoginController {

    private final UserService userService;

    @GetMapping("/home")
    public String loginController() {
        return "/home";
    }

    @GetMapping("/login")
    public String returnLogin() {
        return "/login";
    }

    @PostMapping("/login")
    public String signInController(
            @ModelAttribute UserSignInRequestDto requestDto,
            HttpServletRequest servletRequest
    ) {

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        UserSignInResponseDto responseDto = userService.login(email, password);//유저 존재하는지 체크

        HttpSession session = servletRequest.getSession();

        session.setAttribute(Const.LOGIN_USER, responseDto);

        return "/home";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest servletRequest) {
        HttpSession session = servletRequest.getSession(false);
        if (session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }

        return "login";
    }


}
