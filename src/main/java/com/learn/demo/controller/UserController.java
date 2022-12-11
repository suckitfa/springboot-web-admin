package com.learn.demo.controller;

import com.learn.demo.bean.User;
import com.learn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    @ResponseBody
    public Map<String,Object> getUsers() {
        Map<String,Object> map = new HashMap<>();
        List<User> list = userService.list();
        map.put("data",list);
        return map;
    }
}
