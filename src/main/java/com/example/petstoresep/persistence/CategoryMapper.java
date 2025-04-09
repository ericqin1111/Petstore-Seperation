package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.vo.CategoryVO;
import com.example.petstoresep.vo.ItemP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    @Select("select * FROM category where catId = #{categoryId}")
    Category selectById(String categoryId);

    @Select("SELECT * FROM itemP WHERE name  COLLATE utf8_general_ci LIKE CONCAT('%', #{key}, '%')")
    List<ItemP> findItemByProductNameLike(String key);
}
