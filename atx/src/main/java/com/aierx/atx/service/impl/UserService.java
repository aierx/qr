package com.aierx.atx.service.impl;

import com.aierx.atx.model.User;
import com.aierx.atx.service.IUserService;

/**
 * @author leiwenyong
 * @since 2022-07-12
 */
public class UserService implements IUserService {
    @Override
    public User getUser() {

        return new User("leiwenyong");
    }
}
