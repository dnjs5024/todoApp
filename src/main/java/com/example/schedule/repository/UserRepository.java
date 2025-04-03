package com.example.schedule.repository;

import com.example.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserRepository 오류입니다"));
    }

    public Optional<User> findByEmail(String email);

    public Optional<User> findByPassword(String password);
}
