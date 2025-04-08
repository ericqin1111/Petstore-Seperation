package com.example.petstoresep.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.petstoresep.entity.JwtUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<JwtUser> {
    @Insert("INSERT INTO signon(username, password) VALUES(#{username},#{password} )")
    int registerUser( String username, String password);

    //自定义查询账号方法
    @Select("SELECT * FROM signon WHERE username = #{username}")
    JwtUser selectLogin(@Param("username") String username);


}
