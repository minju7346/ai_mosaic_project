package com.project.graduation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {


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
