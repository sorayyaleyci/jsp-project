package org.sorayya.project.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBC {

    private JDBC(){}
    private final static BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();
    static{
        BASIC_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        BASIC_DATA_SOURCE.setUrl("jdbc:oracle:thin:@//localhost:1521/orclpdb1");
        BASIC_DATA_SOURCE.setUsername("sorayya1");
        BASIC_DATA_SOURCE.setPassword("myjava123");
        BASIC_DATA_SOURCE.setMaxTotal(10);
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = BASIC_DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;

    }
}
