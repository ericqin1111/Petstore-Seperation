package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImageMapper extends BaseMapper<Image> {
    @Select("SELECT itemid, image_data as imageData,file_name as fileName FROM images WHERE itemid = #{itemId}")
    java.awt.Image getImageById(@Param("itemId") String id) ;

}
