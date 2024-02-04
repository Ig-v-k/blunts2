package com.iw;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest {
    private Connection con;
    @Before
    public void initialize() throws SQLException {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        con.setSchema("public");
        con.setAutoCommit(false);
    }

    @Test
    public void mainSchema() throws SQLException {
        assertThat(con.getSchema()).isEqualTo("public");
    }

    @Test
    public void row() throws SQLException {
        final Statement st = con.createStatement();
        final ResultSet rs = st.executeQuery("SELECT * FROM person");
        rs.next();
        final int row = rs.getRow();
        assertThat(row).isEqualTo(1);
    }
}
