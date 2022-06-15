package org.lihanyu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lihanyu.domain.User;

import java.util.List;


public interface UserMapper {

    //查询所有内容
    @Select("select * from user_db;")
    List<User> selectAll();

    //数据库中增加用户
    @Insert("insert into user_db values(null,#{username},#{email},#{phone};")
    void addUser(User user);

    @Update("update user_db set username=#{username},email=#{email},phone=#{phone} where id=#{id};")
    void updateUser(User user);


}
