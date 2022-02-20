package org.example.service.rs;


import org.example.model.User;

public class UserService  implements IUserService{

    @Override
    public User getUserById(int id) {
        return new User("leiwenyong","1231231231");
    }
}
