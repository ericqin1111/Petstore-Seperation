package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.Category;
import com.example.petstoresep.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("SELECT * FROM category WHERE name LIKE CONCAT('%', #{key}, '%')")
    List<CategoryVO> findCategoryByNameLike(String key);
}
