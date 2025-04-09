package com.example.petstoresep.service;

import com.example.petstoresep.entity.JwtUser;
import com.example.petstoresep.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 从数据库查询用户信息（包括权限）
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername(username);
        jwtUser.setPassword(userMapper.selectLogin(username));
        List<String> list = new ArrayList<>();
        jwtUser.setRole(list);
        jwtUser.getRole().add("USER");

        // 转换权限为 GrantedAuthority 集合
        List<GrantedAuthority> authorities = jwtUser.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        // 构建 UserDetails 对象
        return new org.springframework.security.core.userdetails.User(
                jwtUser.getUsername(),
                jwtUser.getPassword(), // 密码字段（即使 JWT 不包含密码，此处需占位）
                authorities
        );
    }
}