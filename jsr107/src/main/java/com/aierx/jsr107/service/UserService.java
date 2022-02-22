package com.aierx.jsr107.service;

import com.aierx.jsr107.ME;
import com.aierx.jsr107.dao.UserDao;
import com.aierx.jsr107.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserService2 userService2;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

//    @Cacheable(value = "myCache", key = "#id")
    @ME
    @Transactional
    public User getUser(int id) {
        return userDao.findUserById(id);
    }

    @CachePut(value = "myCache", key = "#user.id")
    public User updateUser(User user) {
        user.setUsername("外部事2323232务");
        user.setId(1);
        userDao.updateUser(user);
        userService2.update(user);
        return userDao.findUserById(1);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void update(User user){
        user.setUsername("woshis111hui");
        user.setId(2);
        userDao.updateUser(user);
    }


    public User saveUserToRedis(User user) throws Exception {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set(String.valueOf(user.getId()), "dsdadada");
        return userDao.findUserById(1);
    }
}
