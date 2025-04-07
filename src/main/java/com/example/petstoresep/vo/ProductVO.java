package com.example.petstoresep.vo;

import com.example.petstoresep.entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    private String categoryId;
    private String productId;
    private String name;
    private List<Item> itemList;
}
