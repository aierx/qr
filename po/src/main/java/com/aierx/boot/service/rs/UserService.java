package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Override
    public UserPO getUser(){
        return new UserPO("leiwen","yong");
    }

    @Override
    public UserPO updateUser(UserPO userPO) {
        return userPO;
    }
}
