package com.iw.container;

import com.iw.Container;
import com.iw.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PgContainer implements Container {

    private final String url;

    public PgContainer(final JDBC jdbc) {
        this(jdbc.url());
    }

    public PgContainer(final String url, final String user, final String password) {
        this(String.format("%s?user=%s&password=%s", url, user, password));
    }

    private PgContainer(String url) {
        this.url = url;
    }

    @Override
    public Connection conn() throws SQLException {
        final Connection connection = DriverManager.getConnection(url);
        connection.setSchema("public");
        connection.setAutoCommit(false);
        return connection;
    }
}
