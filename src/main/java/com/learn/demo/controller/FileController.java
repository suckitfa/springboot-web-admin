package com.learn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {
    @PostMapping("/file/save")
    public String saveFile() {
        return "hello";
    }
}
