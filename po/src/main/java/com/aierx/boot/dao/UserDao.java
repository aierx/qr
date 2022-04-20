package com.aierx.boot.dao;

import com.aierx.boot.model.po.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/19
 */
public interface UserDao {

    int updateUserById(UserPO userPO);


    int deleteUserById(@Param("userId") String userId);


    int insertUser(UserPO userPO);


    List<UserPO> getUserById(@Param("userId") String userId);

}
