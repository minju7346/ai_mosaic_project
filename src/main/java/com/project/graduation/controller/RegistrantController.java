package com.project.graduation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("registrant")
public class RegistrantController {

    @GetMapping("/list")
    public String printListPage() {
        return "regi-list";
    }

    @GetMapping("/add")
    public String printAddPage() {
        return "regi-add";
    }

    @GetMapping("/take")
    public String printTakePage() {
        //save service -> fileService.saveFile(file) -> 파일 DB에 먼저 올리기
        return "regi-name";
    }

    @PostMapping("/save") //이름과 함께 파일 불러와서 저장
    public String saveRegistrant() {
        //save service(db에 파일과 사용자가 입력한 name으로 registrant테이블에 저장)
        return "regi-end";
    }

    @GetMapping("/delete")
    public String deleteRegistrant() {
        //delete service
        return "redirect:/";
    }
}
