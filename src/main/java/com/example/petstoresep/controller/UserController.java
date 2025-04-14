package com.example.petstoresep.controller;

import com.example.petstoresep.entity.JwtUser;
import com.example.petstoresep.persistence.UserMapper;
import com.example.petstoresep.util.Response;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Response> register(@RequestBody JwtUser user){

        if(user!=null){
            String password =userMapper.selectLogin(user.getUsername());
            if(password == null){
                PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
                String encode=passwordEncoder.encode(user.getPassword());
                int result=userMapper.registerUser(user.getUsername(),encode);
                return ResponseEntity.ok(Response.success(result));
            }
            else
                return ResponseEntity.ok(Response.error(1,"用户已存在"));
        }
        else {
            return ResponseEntity.ok(Response.error(1,"用户已存在"));
        }

    }


}
