package com.example.petstoresep.service;

import com.example.petstoresep.vo.CategoryVO;
import com.example.petstoresep.vo.ProductVO;

import java.util.List;

public interface CatalogService {
    public CategoryVO getCategory(String categoryId);

    public List<CategoryVO> searchCategory(String key);

    public ProductVO getProduct(String productId);
}
