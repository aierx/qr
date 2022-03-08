package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private static List<UserPO> userPOS;
    static {
        userPOS = new ArrayList<>();
        userPOS.add(new UserPO("lei","yong"));
        userPOS.add(new UserPO("ao","teman"));
        userPOS.add(new UserPO("ao","bama"));
        userPOS.add(new UserPO("lei","文勇"));
        userPOS.add(new UserPO("lei","文杰"));
    }
    @Override
    public UserPO getUser(int id){
        return userPOS.get(id);
    }

    @Override
    public UserPO updateUser(UserPO userPO) {
        return userPO;
    }
}
