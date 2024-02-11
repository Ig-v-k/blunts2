package com.iw;

import com.iw.jdbc.EnvJDBC;
import com.iw.jdbc.ProcessBuilderJDBC;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class JDBCTest {
    @Test
    public void def() {
        final String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
        final JDBC jdbc = new ProcessBuilderJDBC();
        assertThat(jdbc.url()).isEqualTo(url);
    }

    @Test
    public void processBuilder() {
        final JDBC jdbc = new ProcessBuilderJDBC();
        assertThat(jdbc.url()).isEqualTo("[database type]://[username]:[password]@[host]:[port]/[database name]?user=postgres&password=postgres");
    }

    @Test
    public void environment() {
        final JDBC jdbc = new EnvJDBC();
        assertThat(jdbc.url()).isEqualTo("[database type]://[username]:[password]@[host]:[port]/[database name]?user=postgres&password=postgres");
    }
}
