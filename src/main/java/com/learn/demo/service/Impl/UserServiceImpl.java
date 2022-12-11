package com.learn.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.demo.mapper.UserMapper;
import com.learn.demo.service.UserService;
import com.learn.demo.bean.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
