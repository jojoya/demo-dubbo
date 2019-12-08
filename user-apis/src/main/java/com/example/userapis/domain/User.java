package com.example.userapis.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * dubbo 传递的pojo需要实现序列化
 * */
@Data
@ToString
public class User implements Serializable{
    private Integer userNo;
    private String userName;
}
