package com.learn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DataController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB() {
        Long along = jdbcTemplate.queryForObject("select count(*) from account_tbl",long.class);
        return along.toString();
    }
}
