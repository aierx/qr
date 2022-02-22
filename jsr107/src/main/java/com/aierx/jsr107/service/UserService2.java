package com.aierx.jsr107.service;

import com.aierx.jsr107.dao.UserDao;
import com.aierx.jsr107.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService2 {
    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void update(User user){
        user.setUsername("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        user.setId(2);
        userDao.updateUser(user);
    }
}
