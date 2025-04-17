package com.example.petstoresep.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("images")
public class Image {
    @TableField("itemid")
    String itemId;
    @TableField("image_data")
    byte[] imageData;
    @TableField("file_name")
    String fileName;
}
