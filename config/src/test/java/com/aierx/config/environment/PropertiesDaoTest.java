package com.aierx.config.environment;

import com.aierx.config.entity.Properties;
import com.aierx.config.entity.PropertiesDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author leiwenyong
 * @since 2022/3/13
 */
public class PropertiesDaoTest {
    private static PropertiesDao mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(PropertiesDaoTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/PropertiesDaoTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(PropertiesDao.class, builder.openSession(true));
    }


    @Test
    public void testFindAllById() {
        mapper.findAllById(1);
    }

    @Test
    public void testInsert() {
        mapper.insert(new Properties(2,"aaa","aaaaa"));
    }
}
