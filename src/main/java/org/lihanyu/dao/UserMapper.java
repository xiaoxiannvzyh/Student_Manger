package org.lihanyu.dao;

import org.apache.ibatis.annotations.*;
import org.lihanyu.domain.User;

import java.util.List;


public interface UserMapper {

    //查询所有内容
    @Select("select * from user_db;")
    @Results(value = {
            @Result(property = "name", column = "user_name")
    })
    List<User> selectAll();

    //数据库中增加用户
    @Insert("insert into user_db values(null,#{name},#{email},#{phone});")
    void addUser(User user);

    //数据库中更新用户
    @Update("update user_db set username=#{username},email=#{email},phone=#{phone} where id=#{id};")
    void updateUser(User user);

    //查找指定id的用户
    @Select("select * from user_db where id = #{id} ")
    User findById(Integer id);

    //删除用户
    @Delete("delete from user_db where id = #{id} ")
    void delete(Integer id);

}
