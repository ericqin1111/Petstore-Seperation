package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.CartStore;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartStoreMapper extends BaseMapper<CartStore> {

    @Delete("DELETE FROM cartstore WHERE username = #{username}")
    public void clearCartStoreByUsername(String username);

    @Insert("INSERT INTO cartstore(`username`, `itemid`, `quantity`) VALUES(#{username},#{itemId},#{quantity})")
    public void insertCartStore(String username, String itemId, int quantity);

    @Delete("DELETE FROM cartstore WHERE username = #{username} AND itemid = #{itemId}")
    public void deleteCartStoreByUsernameAndItemId(String username, String itemId);

    @Update("UPDATE cartstore SET quantity = quantity + 1 WHERE username = #{username} AND itemid = #{itemId}")
    public void increaseCartStoreQuantity(String username, String itemId);

    @Update("UPDATE cartstore SET quantity = #{quantity} WHERE username= #{username} AND itemid = #{itemId}")
    public void updateCartStoreQuantity(String username, String itemId, int quantity);

    @Select("SELECT * from cartstore where username = #{username}")
    public List<CartStore> getCartStoreByUsername(String username);

    @Select("SELECT EXISTS(SELECT 1 FROM cartstore WHERE username = #{username} AND itemid= #{itemId});")
    public boolean isCartStoreExist(String username, String itemId);
}
