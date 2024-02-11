package com.iw.jdbc;

import com.iw.JDBC;

public final class ProcessBuilderJDBC implements JDBC {

    private final String dbEnv;
    private final String usernameEnv;
    private final String passwordEnv;

    public ProcessBuilderJDBC() {
        this("JDBC_DATABASE_URL", "JDBC_DATABASE_USERNAME", "JDBC_DATABASE_PASSWORD");
    }

    public ProcessBuilderJDBC(String dbEnv, String usernameEnv, String passwordEnv) {
        this.dbEnv = dbEnv;
        this.usernameEnv = usernameEnv;
        this.passwordEnv = passwordEnv;
    }

    @Override
    public String url() {
        final ProcessBuilder builder = new ProcessBuilder();
        final String url = builder.environment()
                .getOrDefault(dbEnv, "jdbc:postgresql://localhost:5432/postgres");
        final String username = builder.environment()
                .getOrDefault(usernameEnv, "postgres");
        final String password = builder.environment()
                .getOrDefault(passwordEnv, "postgres");
        return String.format("%s?user=%s&password=%s", url, username, password);
    }
}
