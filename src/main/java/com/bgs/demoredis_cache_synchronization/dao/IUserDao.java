package com.bgs.demoredis_cache_synchronization.dao;

import com.bgs.demoredis_cache_synchronization.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserDao {

    @Select("select * from user")
    public List<User> findUsers();

    @Insert("insert into user(user_nam" +
            "e) values(#{user_name})")
    public void saveUser(User user);

}
