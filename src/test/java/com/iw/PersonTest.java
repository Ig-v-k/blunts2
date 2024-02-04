package com.iw;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

public final class PersonTest extends ConnAbstract {
    @Test
    public void code() {
        final String query = "SELECT * FROM person";
        try (final Statement st = con.createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            rs.next();
            final int row = rs.getRow();
            if (row > 0) {
                final int code = rs.getInt("code");
                assertThat(code).isGreaterThan(0);
            } else {
                final String mes = String.format("Cannot find column 'code' with query: \"%s\"", query);
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
