package com.bgs.demoredis_cache_synchronization.service;

import com.bgs.demoredis_cache_synchronization.bean.User;

import java.util.List;

public interface IUserService {

    public List<User> findUsers();

    public void saveUser(User user);
}
