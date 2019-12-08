package com.example.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.consumer.service.ITestSystemService;
import com.example.userapis.api.UserService;
import com.example.userapis.domain.User;
import org.springframework.stereotype.Service;

@Service
public class TestSystemServiceImpl implements ITestSystemService {

//    @Reference(version = "2.6.0", url = "dubbo://192.168.1.7:20880")
    @Reference(version = "1.0")
    UserService userService;

    @Override
    public User getUser(Integer userNo) {
        User user = userService.getUserByUserNo(userNo);
        return user;
    }
}
