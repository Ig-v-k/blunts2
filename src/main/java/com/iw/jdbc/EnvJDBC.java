package com.iw.jdbc;

import com.iw.JDBC;

import java.util.Map;

public final class EnvJDBC implements JDBC {

    private final String dbEnv;
    private final String usernameEnv;
    private final String passwordEnv;

    public EnvJDBC() {
        this("JDBC_DATABASE_URL", "JDBC_DATABASE_USERNAME", "JDBC_DATABASE_PASSWORD");
    }

    public EnvJDBC(String dbEnv, String usernameEnv, String passwordEnv) {
        this.dbEnv = dbEnv;
        this.usernameEnv = usernameEnv;
        this.passwordEnv = passwordEnv;
    }

    @Override
    public String url() {
        final Map<String, String> env = System.getenv();
        final String url = env.getOrDefault(dbEnv, "jdbc:postgresql://localhost:5432/postgres");
        final String username = env.getOrDefault(usernameEnv, "postgres");
        final String password = env.getOrDefault(passwordEnv, "postgres");
        return String.format("%s?user=%s&password=%s", url, username, password);
    }
}
