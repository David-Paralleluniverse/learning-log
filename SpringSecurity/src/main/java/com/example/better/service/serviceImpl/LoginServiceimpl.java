package com.example.better.service.serviceImpl;

import com.example.better.entity.ResponseResult;
import com.example.better.entity.User;
import com.example.better.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.example.better.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class LoginServiceimpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult<Map> login(User user) {
        //AuthenticationManager authenticate进行用户认证
        //AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        //如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getUid().toString();
        String jwt = JwtUtil.genAccessToken(userid);
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        ResponseResult<Map> responseResult = new ResponseResult<Map>();
        responseResult.setData(map);
        responseResult.setMsg("登陆成功");
        responseResult.setCode(200);
        return responseResult;
    }
}
