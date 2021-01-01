package com.bgs.demoredis_cache_synchronization.service.impl;

import com.bgs.demoredis_cache_synchronization.bean.User;
import com.bgs.demoredis_cache_synchronization.dao.IUserDao;
import com.bgs.demoredis_cache_synchronization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
