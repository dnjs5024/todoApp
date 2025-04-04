package com.example.schedule.serviceimpl;

import com.example.schedule.config.PasswordEncoder;
import com.example.schedule.dto.user.*;
import com.example.schedule.entity.User;
import com.example.schedule.exception.RuntimeCustomException;
import com.example.schedule.myenum.ErrorEnum;
import com.example.schedule.repository.UserRepository;
import com.example.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //비밀번호 암호화
    private final PasswordEncoder passwordEncoder;

    /**
     * 유저 정보 저장하는 메소드
     *
     * @param requestDto not null 유저 이름, 이메일 , 비밀번호 받아서 저장
     * @return 등록한 유저정보와 상태코드 리턴
     */
    @Override
    public ResponseEntity<UserSignUpResponseDto> save(UserSignUpRequestDto requestDto) {

        User user = new User(
                requestDto.getName(),
                requestDto.getEmail(),
                passwordEncoder.encode(requestDto.getPassword()));//비밀번호 암호화 저장

        User saveData = userRepository.save(user);

        return new ResponseEntity<>(new UserSignUpResponseDto(saveData.getName(), saveData.getEmail()), HttpStatus.OK);
    }

    /**
     * 유저이름과 이메일을 수정하는 메소드 유저id값을 받아서 해당 데이터를 수정한다
     *
     * @param requestDto not null
     * @param id         not null
     * @return 200 응답코드 OK
     */
    @Transactional
    @Override
    public ResponseEntity<String> update(UserUpdateRequestDto requestDto, long id) {

        User user = userRepository.findByIdOrElseThrow(id);

        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 모든 유저정보 조회
     *
     * @return db에 존재하는 유저정보 List에 담아서 리턴
     */
    @Override
    public ResponseEntity<List<UserFindResponseDto>> findAll() {
        return new ResponseEntity<>(UserFindResponseDto.toDto(userRepository.findAll()), HttpStatus.OK);
    }

    /**
     * 유저id값 받아서 해당 데이터 삭제
     *
     * @param id 유저id
     */
    @Override
    public void delete(long id) {

        userRepository.delete(userRepository.findByIdOrElseThrow(id));

    }

    /**
     * 로그인 관리 메소드 이메일과 비번을 체크하고 존재하면 user정보를 리턴해줌
     *
     * @param email    not null
     * @param password not null
     * @return User -> UserSignInResponseDto 바꿔서 리턴해줌
     */
    @Override
    public UserSignInResponseDto login(String email, String password) {
        //이메일 체크 1. 에러메시지  2. 필드 이름
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeCustomException(ErrorEnum.EMAIL_MISS.getMessage(),"email"));

        if (!passwordEncoder.matches(password, user.getPassword()))//1. 입력한 비번 2. db에서 암호화 저장한 비번
            //비번틀리면 오류 1. 에러메시지  2. 필드 이름
            throw new RuntimeCustomException(ErrorEnum.PASSWORD_MISS.getMessage(),"password");
        return new UserSignInResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Override
    public boolean isEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
