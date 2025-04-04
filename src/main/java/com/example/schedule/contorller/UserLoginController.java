package com.example.schedule.contorller;


import com.example.schedule.dto.user.UserSignInRequestDto;
import com.example.schedule.dto.user.UserSignInResponseDto;
import com.example.schedule.myconst.Const;
import com.example.schedule.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
    public String homeController() {
        return "/home";
    }

    @GetMapping("/login")
    public String returnLogin() {
        return "/login";
    }

    /**
     * 로그인 컨트롤러 이메일 아이디 가져와서 디비에 존재하는지 비번 맞는지 체크
     * @param requestDto 유저 이메일 이름 받음
     * @param servletRequest 세션다루기 위한
     * @return 홈화면으로 페이지 이동
     */
    @PostMapping("/login")
    public String signInController(
            @ModelAttribute @Valid UserSignInRequestDto requestDto,
            HttpServletRequest servletRequest
    ) {

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        UserSignInResponseDto responseDto = userService.login(email, password);//유저 존재하는지 체크

        HttpSession session = servletRequest.getSession();

        session.setAttribute(Const.LOGIN_USER, responseDto);

        return "redirect:home";
    }

    /**
     * 로그아웃 세션 삭제함
     * @param servletRequest 세션 다루기 위해서
     * @return 다시 로그인 페이지로 이동
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest servletRequest) {
        HttpSession session = servletRequest.getSession(false);
        if (session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }

        return "redirect:login";
    }


}
