package com.example.petstoresep.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


//储存不同用户的购物车信息
@Data
@TableName("cartstore")
public class CartStore {
    @TableId(value ="username")
    private String userName;
    @TableField("itemid")
    private String itemId;
    @TableField("quantity")
    private Integer quantity;
}
