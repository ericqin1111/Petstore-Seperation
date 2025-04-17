package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.vo.ItemP;
import com.example.petstoresep.vo.ItemVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper extends BaseMapper<Item> {
    @Select("select " +
            "i.itemid," +
            "i.productid as productid," +
            "listprice," +
            "unitcost," +
            "supplier as supplierid," +
            "status," +
            "attr1 as attribute1," +
            "attr2 as attribute2," +
            "attr3 as attribute3," +
            "attr4 as attribute4," +
            "attr5 as attribute5, " +
            "category as categoryid," +
            "name as name," +
            "descn as description," +
            "qty as quantity " +
            "from item i, inventory v, product p " +
            "where p.productid = i.productid " +
            "and i.itemid = v.itemid " +
            "and i.itemid = #{itemId} ")
    public ItemVO getItemById(String itemId);


    @Results({
            @Result(property = "attribute1",column = "attr1"),
            @Result(property = "attribute2",column = "attr2"),
            @Result(property = "attribute3",column = "attr3"),
            @Result(property = "attribute4",column = "attr4"),
            @Result(property = "attribute5",column = "attr5"),
            @Result(property = "imageData",column = "image_data"),
            @Result(property = "fileName",column = "file_name")
    })
    @Select("SELECT * FROM itemP")
    public List<ItemP> getAllItem();

    @Select("SELECT * from itemp where itemid=#{itemId}")
    public ItemP getItem(@Param("itemId") String itemId);

//    @Results({
//            @Result(property = "attribute1",column = "attr1"),
//            @Result(property = "attribute2",column = "attr2"),
//            @Result(property = "attribute3",column = "attr3"),
//            @Result(property = "attribute4",column = "attr4"),
//            @Result(property = "attribute5",column = "attr5"),
//            @Result(property = "imageData",column = "image_data"),
//            @Result(property = "fileName",column = "file_name")
//    })
//    @Select("SELECT * FROM itemP")
//    public ItemP getItem(@Param("file"));
}
