package com.project.graduation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class MainController {


    private Object awsS3Service;

    @GetMapping("/start")
    public String printStartPage() {
        return "start";
    }

    @GetMapping("/")
    public String printHomePage() {
        return "home";
    }

    @GetMapping("/login")
    public String printLoginPage() {
        return "login";
    }


}
