package com.aierx.boot.service.rs;

import com.aierx.boot.dao.UserDao;
import com.aierx.boot.model.po.UserPO;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Autowired
    OtherService otherService;
    
    @Autowired
    UserService userService;


    @Override
    @Transactional
    @SentinelResource("getUser")
    public List<UserPO> getUser(String id){
        ObjectMapper objectMapper = new ObjectMapper();
        otherService.otherFun(null);
        return Arrays.asList(new UserPO(null,null,"asdada","adada"));
    }
    

    public void show( String id){
        System.out.println(id);
    }

    public int UpdateUser(UserPO userPO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(userPO);
        System.out.println(s);
        ((UserService) AopContext.currentProxy()).otherFun5(userPO);
        return 2;
    }

    /**
     * 【1】事务失效，被修饰的类为private
     * 因为修饰符为private，生成代理类失败
     * @param userPO
     */
    @Transactional
    private void otherFun(UserPO userPO){
        userPO.setUserName("private");
        userDao.updateUserById(userPO);
    }

    /**
     * 【2】标记为final，无法重写该方法，事务失效
     * @param userPO
     */
    @Transactional
    final void otherFun1(UserPO userPO){
        userPO.setUserName("final");
        userDao.updateUserById(userPO);
    }

    /**
     * 【3】方法内调用，this对象不是代理类
     * @param userPO
     */
    @Transactional
    void otherFun3(UserPO userPO){
        userPO.setUserName("方法内调用");
        userDao.updateUserById(userPO);
    }

    @Transactional
    @Override
    public void otherFun4(UserPO userPO){
        userPO.setUserName("自己注入自己");
        userDao.updateUserById(userPO);
    }

    @Transactional
    public void otherFun5(UserPO userPO){
        userPO.setUserName("AOP创建自己");
        userDao.updateUserById(userPO);
    }




    @Override
    public int deleteUser(UserPO userPO) {
        return userDao.deleteUserById(userPO.getUserId());
    }



    @Override
    public int insertUser(UserPO userPO) {
        return userDao.insertUser(userPO);
    }

    @Override
    public UserPO updateUser(UserPO userPO) {
        return null;
    }
}

