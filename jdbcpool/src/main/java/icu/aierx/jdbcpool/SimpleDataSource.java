package icu.aierx.jdbcpool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class SimpleDataSource implements DataSource {

    private static Log log = LogFactory.getLog(SimpleDataSource.class);

    Properties properties;

    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    public SimpleDataSource(Properties properties) throws ClassNotFoundException, SQLException {
        Class.forName(properties.getDriverClassName());
        for (int i = 0; i < 10; i++) {
            pool.add(DriverManager.getConnection(properties.getUrl(),properties.getUsername(),properties.getPassword()));
        }
        this.properties = properties;
    }


    @Override
    public Connection getConnection() throws SQLException {
        synchronized (pool){
            if (pool.size()>0){
                return pool.removeFirst();
            }
            return makeConnection();
        }
    }

    public static void freeConnection(Connection connection){
        pool.addLast(connection);
    }

    private Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(properties.getUrl(),properties.getUsername(),properties.getPassword());
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(properties.getUrl(),username,password);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
