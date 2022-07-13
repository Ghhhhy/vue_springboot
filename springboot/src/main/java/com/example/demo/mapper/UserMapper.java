package com.example.demo.mapper;

import com.example.demo.entity.Center;
import com.example.demo.entity.CenterInfo;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where username=#{username} and passwords=#{password}")
    User verifyuser(String username,String password);

    @Select("select * from user where username=#{username}")
    User finduser(String username);

    @Update("insert into `user` set username=#{username} , passwords=#{password}")
    void adduser(String username,String password);

    @Select("select * from center where username=#{username} and schoolid=#{id}")
    User findcenter(String username,Integer id);

    @Update("insert into `center` set username=#{username} , schoolid=#{id}")
    void addcenter(String username,Integer id);

    @Select("select * from centerinfo where username=#{username} ")
    List<CenterInfo> Listcenter(String username);

    @Delete("delete from center where username=#{username} and schoolid=#{id}")
    void deletecenter(String username,Integer id);
}
