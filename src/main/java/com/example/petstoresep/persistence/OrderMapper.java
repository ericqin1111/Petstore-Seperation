package com.example.petstoresep.persistence;

import com.example.petstoresep.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Update("UPDATE item_order SET add_time=NOW() WHERE user_name = #{username} AND code = #{code}")
    public void submitOrder(String username, String code);
    @Select("SELECT * FROM item_order WHERE user_name = #{username} AND is_delete = 0")
    public List<Order> getOrder(String username);
    @Update("UPDATE item_order SET is_delete=1 WHERE user_name = #{username} AND code = #{code}")
    public void delete(String username, String code);
    @Update("UPDATE item_order SET status=3 WHERE user_name = #{username} AND code = #{code}")
    public void receive(String username, String code);
}
