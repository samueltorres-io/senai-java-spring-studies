package com.mecparts.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mecparts.config.DBConfig;

public class DBUtil {

    public static Connection getServerConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/?serverTimezone=UTC",
                DBConfig.DB_HOST, DBConfig.DB_PORT);
        return DriverManager.getConnection(url, DBConfig.DB_USER, DBConfig.DB_PASS);
    }

    public static Connection getConnectionTo(String dbName) throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC",
                DBConfig.DB_HOST, DBConfig.DB_PORT, dbName);
        return DriverManager.getConnection(url, DBConfig.DB_USER, DBConfig.DB_PASS);
    }

}
