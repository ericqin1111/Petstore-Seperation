package com.example.petstoresep.controller;

import com.example.petstoresep.entity.JwtUser;
import com.example.petstoresep.persistence.UserMapper;
import com.example.petstoresep.service.impl.UserServiceImpl;
import com.example.petstoresep.util.Response;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<Response> login(@RequestBody JwtUser user, HttpServletResponse response) {
        System.out.println(user);
        if(user==null){
            return ResponseEntity.ok(Response.error(0,"账户不能为空"));
        }

        String msg=userService.login(user);

        if(msg!=""){
            response.addHeader("Authorization", "Bearer " + msg);
            return ResponseEntity.ok(Response.success(null));
        }
        else
            return ResponseEntity.ok(Response.error(1,"用户名不存在或密码错误"));


    }


}
