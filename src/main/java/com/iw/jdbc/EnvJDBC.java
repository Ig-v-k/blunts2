package com.iw.jdbc;

import com.iw.JDBC;

import java.util.Map;

public final class EnvJDBC implements JDBC {

    private final String dbEnv;

    public EnvJDBC() {
        this("JDBC_DATABASE_URL");
    }

    public EnvJDBC(String dbEnv) {
        this.dbEnv = dbEnv;
    }

    @Override
    public String url() {
        final Map<String, String> env = System.getenv();
        final String url = env.getOrDefault(dbEnv,
                String.format("jdbc:postgresql://localhost:5432/postgres?user=%s&password=%s", "postgres", "postgres"));
        return url;
    }
}
