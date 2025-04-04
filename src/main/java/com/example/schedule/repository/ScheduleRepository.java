package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.myenum.ErrorEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ErrorEnum.DATA_NOT_FOUNT.getMessage()
                )
        );
    }

}
