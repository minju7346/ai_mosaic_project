package com.project.graduation.service;

import com.project.graduation.domain.registrant.Registrant;
import com.project.graduation.domain.user.LoginRequest;
import com.project.graduation.repository.RegistrantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrantService {

    private final RegistrantRepository registrantRepository;

    public void saveRegistrant(Registrant registrant)  {
        registrantRepository.save(registrant);
    }

}
