package com.example.schedule.filter;


import com.example.schedule.dto.user.UserSignInRequestDto;
import com.example.schedule.myconst.Const;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/login","/favicon.ico","/user/*"};


    /**
     * WHITE_LIST에 저장된 url 제외하고 나머지는 로그인해야 접근 가능하게 설정
     *
     * @param servletRequest 요청 다루기 위한
     * @param servletResponse 응답 다루기 위한
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        if (!isWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            // 로그인하지 않은 사용자인 경우
            if (session == null || session.getAttribute(Const.LOGIN_USER) == null) {
                httpResponse.sendRedirect("/login");
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isWhiteList(String requestURI) {

        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
