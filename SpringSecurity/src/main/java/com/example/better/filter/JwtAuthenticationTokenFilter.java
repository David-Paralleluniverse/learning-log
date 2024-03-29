package com.example.better.filter;


import com.example.better.mapper.GoodsMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.example.better.utils.JwtUtil;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.better.service.serviceImpl.LoginUser;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    GoodsMapper goodsMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        Integer userid;
        try {
            Claims claims = JwtUtil.parsePayload(token);
            userid = Integer.parseInt(claims.get("userid").toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        /*
        //从redis中获取用户信息
        //从mysql中获取用户信息
        //String redisKey = "login:" + userid;

         */
        LoginUser loginUser = new LoginUser(goodsMapper.SelUserById(userid));
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }


        //存入SecurityContextHolder
        //TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);


    }
}
