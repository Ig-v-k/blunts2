package com.iw.jdbc;

import com.iw.JDBC;

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
        final ProcessBuilder builder = new ProcessBuilder();
        final String url = builder.environment().get(dbEnv);
        final String username = builder.environment().get(usernameEnv);
        final String password = builder.environment().get(passwordEnv);
        return String.format("%s?user=%s&password=%s", url, username, password);
    }
}
