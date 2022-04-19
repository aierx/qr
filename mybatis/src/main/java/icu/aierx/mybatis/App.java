package icu.aierx.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author leiwenyong
 * @since 2022/4/2
 */
@Slf4j
public class App {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sessionFactory.openSession()){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            User user = new User("1", "2", "3", "4");
            mapper.findUserById(8);
        }
    }
    private void hello(){
        System.out.println("我开始调用了");
    }
}
