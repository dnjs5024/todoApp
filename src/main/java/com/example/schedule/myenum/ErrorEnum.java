package com.example.schedule.myenum;

public enum ErrorEnum {//에러코드와 메시지 관리 하는 enum
    //C0** 잘못된 입력
    INPUT_MISS("C001", "잘못된 입력값입니다"),
    PASSWORD_MISS("C002", "비밀번호 틀림"),
    EMAIL_MISS("C003", "이메일 틀림"),
    //N0** 조회결과 없음
    SCHEDULE_NOT("N001", "일정이 존재하지 않습니다"),
    //L0** 로그인 에러
    LOGIN_NOT("LO01", "로그인 해주세요");

    private final String code;
    private final String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
