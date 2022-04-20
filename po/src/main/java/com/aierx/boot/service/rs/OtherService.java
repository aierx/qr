package com.aierx.boot.service.rs;

import com.aierx.boot.dao.UserDao;
import com.aierx.boot.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author leiwenyong
 * @since 2022/4/19
 */
@Service
public class OtherService {

    @Autowired
    UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void otherFun(UserPO userPO) throws Exception {
        try {
            userPO.setUserName("other");
            userDao.updateUserById(userPO);
            int c = 1/0;
        }catch (Exception e){
            throw new Exception("aaaaa");
        }

    }


}
