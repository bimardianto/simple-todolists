package com.amibotnaidra.code.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseUtilTest {

    @Test
    void getDataSource() throws SQLException {
        HikariDataSource databaseUtil = DatabaseUtil.getDataSource();
        Connection connection = databaseUtil.getConnection();

        connection.close();
        databaseUtil.close();
    }
}