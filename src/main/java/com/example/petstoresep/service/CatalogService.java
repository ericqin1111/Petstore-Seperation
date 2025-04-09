package com.example.petstoresep.service;

import com.example.petstoresep.entity.Item;
import com.example.petstoresep.vo.CategoryVO;
import com.example.petstoresep.vo.ItemP;
import com.example.petstoresep.vo.ProductVO;

import java.util.List;

public interface CatalogService {
    public CategoryVO getCategory(String categoryId);

    public List<ItemP> searchItem(String key);

    public ProductVO getProduct(String productId);
}
