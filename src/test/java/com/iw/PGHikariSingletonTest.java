package com.iw;

import com.iw.container.PGHikariSingleton;
import com.iw.jdbc.EnvJDBC;
import org.junit.AfterClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public final class PGHikariSingletonTest {
    private final static Container container = new PGHikariSingleton(new EnvJDBC());

    @Test
    public void connection() {
        try (final Connection conn = container.conn()) {
            assertThat(conn).isNotNull();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void finish() {
        container.close();
    }
}
