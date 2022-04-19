package icu.aierx.mybatis;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/2
 */
public interface UserDao {

    public List<User> findUserAll();

    public User findUserById(int id);


    public int insertUser(@Param("user") User user,@Param("name") String name);


    public int deleteUser(User user);

    public int updateUser(User user);

}
