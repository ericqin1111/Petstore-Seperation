package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
}
