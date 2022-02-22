package com.aierx.jsr107.service;

import com.aierx.jsr107.dao.UserDao;
import com.aierx.jsr107.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Cacheable(value = "user", key = "#id")
    public User getUser(int id) {
        return userDao.findUserById(id);
    }

    @CacheEvict(value = "user", key = "#user.id")
    public User updateUser(User user) {
        userDao.updateUser(user);
        return userDao.findUserById(1);
    }


    public User saveUserToRedis(User user) throws Exception {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set(String.valueOf(user.getId()), "dsdadada");
        return userDao.findUserById(1);
    }
}
