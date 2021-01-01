package com.bgs.demoredis_cache_synchronization.controller;

import com.alibaba.fastjson.JSON;
import com.bgs.demoredis_cache_synchronization.bean.User;
import com.bgs.demoredis_cache_synchronization.service.IUserService;
import com.bgs.demoredis_cache_synchronization.utils.RedisUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private  RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IUserService userService;

    private ApplicationContext ac;

    @RequestMapping("/test")
    public String test(@RequestBody User user){
        //  保存信息到数据库
        userService.saveUser(user);
        List<User> users = userService.findUsers();
        //  获取redis工具类对象
        StringRedisTemplate srt = (StringRedisTemplate) redisTemplate;
        redisUtil.setRedisTemplate(srt);
        String strUsers = JSON.toJSONString(users);
        //  如果redis中有key为“user”,则把它删除
        if(redisUtil.get("user")!=null){
            redisUtil.delete("user");
        }
        //  更新redis中的数据
        redisUtil.set("user",strUsers);
        System.out.println(redisUtil.get("user"));

        return "success";
    }

}
