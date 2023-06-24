package com.project.graduation.service;

import com.project.graduation.domain.user.LoginRequest;
import com.project.graduation.repository.LoginRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginRequestRepository loginRequestRepository;

    public void saveLoginUser(LoginRequest loginRequest)  {
        loginRequestRepository.save(loginRequest);
    }
}
