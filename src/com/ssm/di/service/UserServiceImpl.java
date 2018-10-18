package com.ssm.di.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void say(String value) {
        System.out.println("哈哈哈");
    }

    @Override
    public String speak(String name) {
        return "这是名字"+name;
    }
}
