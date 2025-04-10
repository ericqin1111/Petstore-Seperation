package com.example.petstoresep.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors
@TableName("signon")
public class JwtUser {
    @TableId
    private Long id;
    private boolean valid;
    private String username;
    private String password;
    private List<String> role;

    public JwtUser(){
        this.valid=false;
    }
}
