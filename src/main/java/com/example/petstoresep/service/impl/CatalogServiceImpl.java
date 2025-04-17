package com.example.petstoresep.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.entity.Product;
import com.example.petstoresep.persistence.CategoryMapper;
import com.example.petstoresep.persistence.ItemMapper;
import com.example.petstoresep.persistence.ProductMapper;
import com.example.petstoresep.service.CatalogService;
import com.example.petstoresep.vo.CategoryVO;
import com.example.petstoresep.vo.ItemP;
import com.example.petstoresep.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CatalogService")
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ItemMapper itemMapper;

//    @Autowired
//    InventoryMapper inventoryMapper;

    @Override
    public CategoryVO getCategory(String categoryId) {
        CategoryVO categoryVO=new CategoryVO();
        Category category=categoryMapper.selectById(categoryId);

        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("category",categoryId);
        List<Product> productList=productMapper.selectList(queryWrapper);


        categoryVO.setCategoryId(categoryId);
        categoryVO.setCategoryName(category.getName());
        categoryVO.setProductList(productList);

        return categoryVO;
    }

    @Override
    public List<ItemP> searchItem(String key) {
        return categoryMapper.findItemByProductNameLike(key);
    }

    public ProductVO getProduct(String productId){
        ProductVO productVo=new ProductVO();

        QueryWrapper<Item> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("productId",productId);
        List<Item> itemList=itemMapper.selectList(queryWrapper);
        String categoryId = productMapper.selectById(productId).getCategoryId();


//        for(Item item:itemList){
//            if (inventoryMapper.getInventoryByItemId(item.getItemId())[0].getQty() <= 0){
//                itemList.remove(item);
//            }
//        }

        productVo.setCategoryId(categoryId);
        productVo.setProductId(productId);
        productVo.setItemList(itemList);


        return productVo;
    }

    @Override
    public List<Category> getAllCate() {
        List<Category> list=categoryMapper.getAll();
        for(Category category:list){
            System.out.println(category);
        }
        return list;
    }

    @Override
    public List<Product> getAllPro() {
        return productMapper.getAll();
    }

    @Override
    public List<ItemP> getAllItem() {
        return itemMapper.getAllItem();
    }

    @Override
    public ItemP getItem(String itemId) {
        return itemMapper.getItem(itemId);
    }


}
