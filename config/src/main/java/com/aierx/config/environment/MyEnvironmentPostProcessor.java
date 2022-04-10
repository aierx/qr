package com.aierx.config.environment;

import com.aierx.config.entity.PropertiesDao;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

    private int order = -1;
    @Value("jdbc.url")
    public String aaaa;

    @SneakyThrows
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 从数据库获取配置文件
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PropertiesDao mapper = sqlSession.getMapper(PropertiesDao.class);
        List<PropertiesEntity> all = mapper.findAll();
        Map<String, Object> source1 = all.stream().collect(Collectors.toMap(PropertiesEntity::getName, PropertiesEntity::getValue));
        MapPropertySource mysql = new MapPropertySource("sql", source1);
        environment.getPropertySources().addLast(mysql);
        // 从pom文件获取配置
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        HashMap<String, Object> source = new HashMap<>();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            String userDir = System.getProperty("user.dir");
            Document document = builder.parse(new File(userDir + "/pom.xml"));
            NodeList properties = document.getElementsByTagName("properties");
            for (int i = 0; i < properties.getLength(); i++) {
                NodeList childNodes = properties.item(i).getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        source.put(childNodes.item(j).getNodeName(),childNodes.item(j).getFirstChild().getNodeValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MapPropertySource map = new MapPropertySource("pom",source);
        environment.getPropertySources().addLast(map);
        // 从配置中心获取配置
    }

    @Override
    public int getOrder() {
        return order;
    }
}
