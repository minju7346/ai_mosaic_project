package com.project.graduation.controller;

import com.project.graduation.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class FileController {

    private final FileService fileService;


    @GetMapping("/")
    public void asd() {

        //return "index"
    }

    @GetMapping("/upload")
    public String testUploadForm() {

        return "test/uploadTest";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file ) throws IOException {
        fileService.saveFile(file);

        return "redirect:/";
    }

}