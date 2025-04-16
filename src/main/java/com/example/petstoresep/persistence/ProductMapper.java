package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {
    @Results({
            @Result(property = "productId", column = "productid"),
            @Result(property = "description", column = "descn"),
            @Result(property = "categoryId",column = "category")
    })
    @Select("select * from product")
    List<Product> getAll();

}
