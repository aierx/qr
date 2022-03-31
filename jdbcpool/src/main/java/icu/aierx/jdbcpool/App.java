package icu.aierx.jdbcpool;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class App implements ApplicationContextAware {


    @Bean
    public DataSource getDataSource(Properties properties) throws ClassNotFoundException, SQLException {
        return new SimpleDataSource(properties);
    }


    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        DataSource dataSource = context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        Statement preparedStatement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery("select * from db_user");
        User user = new User();
        while (resultSet.next()) {
            user.setUaername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("username"));
        }
        System.out.println(preparedStatement);
    }

    ConfigurableApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = (ConfigurableApplicationContext) applicationContext;
    }
}
