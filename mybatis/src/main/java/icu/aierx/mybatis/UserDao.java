package icu.aierx.mybatis;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/2
 */
public interface UserDao {

    public List<User> findUserAll();

    public User findUserById(int id);


    public int insertUser(User user);


    public int deleteUser(User user);

    public int updateUser(User user);

}
