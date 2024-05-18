package com.example.better.controller;


import com.example.better.entity.ResponseResult;
import com.example.better.entity.User;
import com.example.better.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/uet")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("login")
    public ResponseResult<Map> login(@RequestBody User user){
        return loginService.login(user);
    }

    @PostMapping("reg")
    public String reg(@RequestBody User user){
        System.out.println(passwordEncoder.encode(user.getPassword()));
        return "ok";
    }

}
