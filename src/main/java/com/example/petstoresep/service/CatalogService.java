package com.example.petstoresep.service;

import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.entity.Product;
import com.example.petstoresep.vo.CategoryVO;
import com.example.petstoresep.vo.ItemP;
import com.example.petstoresep.vo.ProductVO;

import java.util.List;

public interface CatalogService {
    public CategoryVO getCategory(String categoryId);

    public List<ItemP> searchItem(String key);

    public ProductVO getProduct(String productId);

    public List<Category> getAllCate();

    public List<Product> getAllPro();

    public List<ItemP> getAllItem();

    public ItemP getItem(String itemId);
}
