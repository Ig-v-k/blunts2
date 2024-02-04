package com.iw;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest {
    private Connection con;
    @Before
    public void initialize() throws SQLException {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        con.setSchema("public");
    }

    @Test
    public void mainSchema() throws SQLException {
        assertThat(con.getSchema()).isEqualTo("public");
    }
}
