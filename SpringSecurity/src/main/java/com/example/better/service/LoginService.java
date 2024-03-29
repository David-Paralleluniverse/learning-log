package com.example.better.service;

import com.example.better.entity.ResponseResult;
import com.example.better.entity.User;

import java.util.Map;

public interface LoginService {
    ResponseResult<Map> login(User user);
}
