package com.learn.demo.controller;

import com.learn.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {
    /**
     * @return 登入页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage() {
        // 模版的名字
        return "login";
    }

    @PostMapping("/login")
    public String main(@RequestBody Map<String,String> loginInfo, User user, HttpSession session, Model model) {
        if(user.getUsername().length() != 0 && "123456".equals(user.getPassword()) ) {
            // 保存登入成功的用户
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";

        } else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }

    // 处理表单重复提交, 重定向页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
       Object loginUser =  session.getAttribute("loginUser");
       if(loginUser != null) {
           return "main";
       } else {
           model.addAttribute("msg","请重新登入");
           return "login";
       }

    }

}
