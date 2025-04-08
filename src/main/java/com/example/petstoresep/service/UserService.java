package com.example.petstoresep.service;

import com.example.petstoresep.entity.JwtUser;
import com.example.petstoresep.persistence.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

public String login(@Param("user") JwtUser user);


}
