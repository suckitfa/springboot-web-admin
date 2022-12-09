package com.learn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    /**
     * @return 登入页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage() {
        return "login";
    }
}
