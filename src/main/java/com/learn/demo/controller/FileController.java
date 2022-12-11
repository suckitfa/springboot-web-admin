package com.learn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileController {
    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }
    @PostMapping("/upload")
    public String saveFile(
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestPart("headerImg") MultipartFile headerImage,
            @RequestPart("photos") MultipartFile[] photos
            ) throws IOException {
        log.info("上传信息： email={},username={},headerImaga={}.,photos={}",email,username,headerImage.getSize(),photos.length);
        if(!headerImage.isEmpty()) {
            String originalFilename = headerImage.getOriginalFilename();
            // 保存到文件服务 OSS
            // 1. 文件流
            String originalFileName = headerImage.getOriginalFilename();
            headerImage.transferTo(new File("/Users/bobtang/Desktop/tmp/" + originalFileName));
        }
        if(photos.length > 0) {
            for(MultipartFile photo: photos) {
                if(!photo.isEmpty()) {
                    String originalFileName = photo.getOriginalFilename();
                    photo.transferTo(new File("/Users/bobtang/Desktop/tmp/" + originalFileName));
                }
            }
        }
        return "login";
    }
}
