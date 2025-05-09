package com.example.schedule.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "user")
public class User extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Nullable
    private String name;

    @Column(unique = true)
    @Nullable
    private String email;

    @Column(nullable = false)
    @Nullable
    private String password;

    //기본 생성자
    public User() {

    }

    public User(String userName, String userEmail, String password) {
        this.name = userName;
        this.email = userEmail;
        this.password = password;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public void setName(String userName) {
        this.name = userName;
    }
}
