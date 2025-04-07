package com.example.petstoresep.vo;

import com.example.petstoresep.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {


        private String categoryId;
        private String categoryName;
        private List<Product> productList;
        private String desn;


}
