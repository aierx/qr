package org.example.rs.service.rs;


import org.example.rs.model.User;

public class UserService  implements IUserService{

    @Override
    public User getUserById(int id) {
        return new User("leiwenyong","1231231231");
    }
}
