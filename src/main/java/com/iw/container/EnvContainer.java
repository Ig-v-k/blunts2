package com.iw.container;

import com.iw.Container;

import java.sql.Connection;
import java.sql.SQLException;

public final class EnvContainer implements Container {

    private final ProcessBuilder builder;

    public EnvContainer(ProcessBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Connection conn() throws SQLException {
        return null;
    }
}
