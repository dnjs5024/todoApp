package com.example.schedule.repository;


import com.example.schedule.entity.Comment;
import com.example.schedule.myenum.ErrorEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ErrorEnum.DATA_NOT_FOUNT.getMessage()
                )
        );
    }

}
