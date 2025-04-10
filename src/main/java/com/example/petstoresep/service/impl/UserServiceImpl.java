package com.example.petstoresep.service.impl;

import com.example.petstoresep.entity.JwtUser;
import com.example.petstoresep.persistence.UserMapper;
import com.example.petstoresep.service.UserService;
import com.example.petstoresep.util.JwtUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    public String login(JwtUser user) {
        JwtUser reqUser = userMapper.selectLogin(user.getUsername());

        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        if (reqUser != null && passwordEncoder.matches(user.getPassword(), reqUser.getPassword())) {
            // 用户名和密码匹配，生成JWT
            return JwtUtil.createToken(user.getUsername());
        }

        return "";
    }


}