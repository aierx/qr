package com.aierx.boot.service.rs;

import com.aierx.boot.A2A;
import com.aierx.boot.NotifyES;
import com.aierx.boot.dao.UserDao;
import com.aierx.boot.model.po.CC;
import com.aierx.boot.model.po.UserPO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService, ApplicationContextAware {
    
    private final SqlSessionFactory sqlSessionFactory = null;
    
    private final ExecutorType executorType = null;
    
    private final SqlSession sqlSessionProxy = null;
    
    private final PersistenceExceptionTranslator exceptionTranslator = null;

    @Autowired
    UserDao userDao;

    @Autowired
    IOtherService otherService;
    
    @Autowired
    UserService userService;
    int max = 10000;
    int min = 100;
    
    @Autowired
    RedisTemplate redisTemplate;
    
    @Override
//    @Transactional
    @NotifyES(value = "[1].userName", desc = "", name = "decision")
    @A2A
    public List<UserPO> getUser(String id, UserPO userPO) throws InterruptedException {
        log.info("进入锁");
        log.info("业务结束");
        UserPO userPO1 = new UserPO("pre", "asdadada", String.valueOf(((int) (Math.random() * ((max - min) + 1)) + min)), "90");
        otherService.updateData("daaa", userPO1);
        return Arrays.asList(userPO1);
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
    public UserPO updateUser( UserPO userPO) {
        return null;
    }
    
    @Override
    public int UpdateUser(CC c) throws Exception {
        return 10086;
    }
    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

