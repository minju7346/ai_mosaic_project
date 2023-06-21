package com.project.graduation.controller;

import com.project.graduation.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @GetMapping("/")
    public String printFilePage() {
        return "file-upload";
    }

    @GetMapping("/convert")
    public String printFileConvertPage() {
        return "file-convert";
    }

    @PostMapping("/download")
    public String printFileDownloadPage() {

        return "redirect:/";
    }

    @PostMapping("/upload") //파일을 AWS S3에 업로드
    public String uploadFile(@RequestParam("file") MultipartFile file ) throws IOException {
        fileService.saveFile(file);

        return "redirect:/";
    }

}