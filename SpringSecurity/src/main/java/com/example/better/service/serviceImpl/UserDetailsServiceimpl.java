package com.example.better.service.serviceImpl;

import com.example.better.entity.User;
import com.example.better.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {

    @Autowired
    private GoodsMapper gm;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = gm.SelUser(username);
        //查询用户信息
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
        //查询对应权限讯息（授权的内容，不是认证）
        return new LoginUser(user);
    }

}
