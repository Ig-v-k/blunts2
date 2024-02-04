package com.iw;

import org.junit.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest extends ConnAbstract {
    @Test
    public void conn() {
        assertThat(con).isNotNull();
    }

    @Test
    public void mainSchema() throws SQLException {
        assertThat(con.getSchema()).isEqualTo("public");
    }
}
