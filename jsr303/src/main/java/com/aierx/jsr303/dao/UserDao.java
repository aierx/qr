package com.aierx.jsr303.dao;

import com.aierx.jsr303.model.po.UserPO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public int getVersionById(int id);

    public int updateUser(UserPO userPO);
}
