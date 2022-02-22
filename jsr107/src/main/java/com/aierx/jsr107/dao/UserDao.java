package com.aierx.jsr107.dao;

import com.aierx.jsr107.model.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findUserById(int id);

    void updateUser(User user);
}
