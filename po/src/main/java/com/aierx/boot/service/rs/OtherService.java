package com.aierx.boot.service.rs;

import com.aierx.boot.dao.UserDao;
import com.aierx.boot.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/19
 */
@Service
public class OtherService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Transactional(rollbackFor = Exception.class)
    public void otherFun(UserPO userPO) throws Exception {
        try {
            if(userPO.getUserId().equals("10086")){
                return;
            }else {
                userPO.setUserId("100");
            }
            if (userPO.getUserAge().equals("30")){
                userPO.setUserId("111");
            }
            userPO.setUserName("other");
            userDao.updateUserById(userPO);
        }catch (Exception e){
            throw new Exception("aaaaa");
        }

    }

    public void findUser(){
        List<UserPO> user = userService.getUser("1");
        for (UserPO userPO : user) {
            userPO.setUserAge("1");
        }
        if (user.get(1).getUserId().equals("2")){
            System.out.println("aaaaaa");
        }
    }


}
