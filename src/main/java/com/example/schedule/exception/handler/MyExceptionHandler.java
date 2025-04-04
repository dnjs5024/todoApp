package com.example.schedule.exception.handler;

import com.example.schedule.exception.RuntimeCustomException;
import com.example.schedule.myenum.ErrorEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(RuntimeCustomException.class)//입력이 잘 못된 경우 오류 클라이언트로
    public ResponseEntity<Map<String, Object>> runTimeCustomExceptionHandler(
            RuntimeCustomException re,
            HttpServletRequest hsr
    ) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("timestamp", LocalDateTime.now());//현재 시간
        errorMap.put("status", HttpStatus.UNAUTHORIZED.value());// 401
        errorMap.put("error", HttpStatus.UNAUTHORIZED.toString());//"UNAUTHORIZED"
        errorMap.put("code", ErrorEnum.INPUT_MISS.getCode());//커스텀 에러코드
        errorMap.put("message", ErrorEnum.INPUT_MISS.getMessage());//커스텀 메시지
        errorMap.put("path", hsr.getRequestURI());
        errorMap.put("fieldErrors",new HashMap<>(Map.of("field",re.getErrorFieldName(),"message",re.getErrorMsg())));
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> responseStatusExceptionHandler(
            ResponseStatusException re,
            HttpServletRequest hsr){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("timestamp", LocalDateTime.now());//현재 시간
        errorMap.put("status", HttpStatus.UNAUTHORIZED.value());// 401
        errorMap.put("error", HttpStatus.UNAUTHORIZED.toString());//"UNAUTHORIZED"
        errorMap.put("code", ErrorEnum.DATA_NOT_FOUNT);//커스텀 에러코드
        errorMap.put("message", ErrorEnum.DATA_NOT_FOUNT.getMessage());//커스텀 메시지
        errorMap.put("path", hsr.getRequestURI());

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //Controller의 @Valid에 걸렸을 때 오류 클라이언트로 보내주는 메소드
    public ResponseEntity<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException me) {
        return new ResponseEntity<>(me.getBindingResult().getFieldErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class) //@Validated 걸렸을 때 오류 클라이언트로 보내주는 메소드
    public ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException me) {
        return new ResponseEntity<>(me.getConstraintViolations().iterator().next().getMessage(), HttpStatus.BAD_REQUEST);
    }
}
