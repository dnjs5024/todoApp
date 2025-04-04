package com.example.schedule.config;

import com.example.schedule.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean loginFilter() {// 로그인 필터등록
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());//필터 적용
        filterRegistrationBean.setOrder(1);//필터실행순서
        filterRegistrationBean.addUrlPatterns("/*");//필터적용할 URL 지정 * 는 전부

        return filterRegistrationBean;
    }
}
