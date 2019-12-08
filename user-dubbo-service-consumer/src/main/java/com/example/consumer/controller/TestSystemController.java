package com.example.consumer.controller;

import com.example.userapis.domain.User;
import com.example.consumer.service.ITestSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class TestSystemController {

    @Autowired
    ITestSystemService testSystemService;

    @RequestMapping("/get/{userNo}")
    public User getUser(@PathVariable Integer userNo){
        return testSystemService.getUser(userNo);
    }
}
