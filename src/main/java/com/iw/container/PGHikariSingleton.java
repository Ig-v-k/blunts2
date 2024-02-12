package com.iw.container;

import com.iw.Container;
import com.iw.JDBC;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public final class PGHikariSingleton implements Container {

    private final HikariDataSource ds;

    public PGHikariSingleton(JDBC jdbc) {
        this(jdbc.url());
    }

    public PGHikariSingleton(String url) {
        this.ds = new HikariDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(url);
        ds.setPoolName("hikariPool1");
        ds.setMaximumPoolSize(20);
        ds.setMinimumIdle(5);
        ds.setConnectionTimeout(20000);
    }

    @Override
    public Connection conn() throws SQLException {
        return ds.getConnection();
    }

    @Override
    public void close() {
        if (!ds.isClosed()) {
            ds.close();
        }
    }
}
