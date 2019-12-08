package com.example.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.userapis.api.UserService;
import com.example.userapis.domain.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Component
//@Service(protocol = {"rest", "dubbo"})
@Service(version = "1.0",timeout = 10000,interfaceClass = UserService.class)
@Path("user")
public class UserServiceImpl implements UserService {

    @GET
    @Path("get/{userNo}")
    @Override
//    public User getUserByUserNo(@QueryParam("userNo") Integer userNo) {
    public User getUserByUserNo(@PathParam("userNo") Integer userNo) {
//    public User getUserByUserNo(Integer userNo) {
        User user = new User();
        if(userNo==100){
            user.setUserNo(userNo);
            user.setUserName("sf-express");
        }
        return user;
    }
}
