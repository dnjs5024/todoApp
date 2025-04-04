package com.example.schedule.filter;

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
     *
     * @param servletRequest HTTP 요청 다루기 위한 기능이 부족하여 다운 캐스팅 하여 사용
     * @param servletResponse HTTP 응답 다루기 위한 기능이 부족하여 다운 캐스팅 하여 사용
     * @param filterChain FilterChain 의 doFilter 사용해 다음 필터나 서블렛으로 넘겨준다
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

            HttpSession session = httpRequest.getSession(false);//새로운 세션 생성x

            // 로그인하지 않은 사용자인 경우
            if (session == null || session.getAttribute(Const.LOGIN_USER) == null) {
                httpResponse.sendRedirect("/login");
                return;// doFilter 실행 x
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isWhiteList(String requestURI) {

        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);//url 패턴 비교
    }
}
