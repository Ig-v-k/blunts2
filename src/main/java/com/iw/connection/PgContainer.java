package com.iw.connection;

import com.iw.Container;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PgContainer implements Container {

    private final String url;

    public PgContainer(final String url, final String username, final String password) {
        this(String.format("%s?username=%s&password=%s", url, username, password));
    }

    public PgContainer(String url) {
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
