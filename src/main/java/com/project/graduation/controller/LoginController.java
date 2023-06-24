package com.project.graduation.controller;

import com.project.graduation.domain.user.LoginRequest;
import com.project.graduation.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login/google")
    public ResponseEntity<String> loginWithGoogle(@RequestBody LoginRequest loginRequest) {
        // Extract login information from the request body
        String id = loginRequest.getId();
        String email = loginRequest.getEmail();
        String name = loginRequest.getName();

        // Perform necessary login logic
        // ...
        LoginRequest lq = LoginRequest.builder().id(id).name(name).email(email).build();
        loginService.saveLoginUser(lq);
        // Return a response, such as an authentication token or a success message
        String token = generateAuthToken(id);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login/naver")
    public ResponseEntity<String> loginWithNaver(@RequestBody LoginRequest loginRequest) {
        // Extract login information from the request body
        String id = loginRequest.getId();
        String email = loginRequest.getEmail();
        String name = loginRequest.getName();

        // Perform necessary login logic
        // ...
        LoginRequest lq = LoginRequest.builder().id(id).name(name).email(email).build();
        loginService.saveLoginUser(lq);
        // Return a response, such as an authentication token or a success message
        String token = generateAuthToken(id);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login/kakao")
    public ResponseEntity<String> loginWithKakao(@RequestBody LoginRequest loginRequest) {
        // Extract login information from the request body
        String id = loginRequest.getId();
        String email = loginRequest.getEmail();
        String name = loginRequest.getName();

        // Perform necessary login logic
        // ...
        LoginRequest lq = LoginRequest.builder().id(id).name(name).email(email).build();
        loginService.saveLoginUser(lq);
        // Return a response, such as an authentication token or a success message
        String token = generateAuthToken(id);
        return ResponseEntity.ok(token);
    }

    private String generateAuthToken(String userId) {
        // Implement your token generation logic here
        // Generate a secure token based on the user's ID and other information

        // For demonstration purposes, we generate a simple token using the user's ID
        return "TOKEN_" + userId;
    }
}
