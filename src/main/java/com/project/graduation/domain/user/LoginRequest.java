package com.project.graduation.domain.user;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity(name="loginRequest")
public class LoginRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="loginRequest_id")
    private Long loginRequest_id;

    @Column(name="id")
    private String id;
    private String email;
    private String name;


    @Builder
    public LoginRequest(Long loginRequest_id, String id, String email, String name) {
        this.loginRequest_id = loginRequest_id;
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
