package com.example.petstoresep.persistence;

import com.example.petstoresep.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Insert("Insert into item_order (`id`,`item_id`,`user_name`,`code`,`add_time`,`total`,`is_delete`,`status`) VALUES (#{id},#{itemid},#{username},#{code},#{addtime},#{total},#{isdelete},#{status})")
    public void submitOrder(Integer id,String itemid,String username,String code,Date addtime,Integer total,Integer isdelete,Integer status);
    @Select("SELECT * FROM item_order WHERE user_name = #{username} AND is_delete = 0")
    public List<Order> getOrder(String username);
    @Update("UPDATE item_order SET is_delete=1 WHERE user_name = #{username} AND code = #{code}")
    public void delete(String username, String code);
    @Update("UPDATE item_order SET status=3 WHERE user_name = #{username} AND code = #{code}")
    public void receive(String username, String code);
}
