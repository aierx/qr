package icu.aierx.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/2
 */
@Slf4j
public class App {

    public static void main(String[] args) throws IOException {
        log.error("hello world");
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sessionFactory.openSession()){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> userAll = mapper.findUserAll();
        }
        log.error("end。");
    }
}
