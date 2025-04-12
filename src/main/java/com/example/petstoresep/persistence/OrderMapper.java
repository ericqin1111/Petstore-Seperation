package com.example.petstoresep.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    @Update("UPDATE item_order SET add_time=NOW() WHERE user_name = #{username} AND id = #{id}")
    public void submitOrder(String username, Integer id);
}
