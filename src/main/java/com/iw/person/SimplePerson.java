package com.iw.person;

import com.iw.Container;
import com.iw.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public final class SimplePerson implements Person {

    private final Container container;

    private final int id;

    public SimplePerson(Container container, int id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public int code() {
        final String query = String.format("SELECT code FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            final int row = rs.getRow();
            if (row > 0) {
                final int code = rs.getInt("code");
                return code;
            } else {
                final String mes = String.format(
                        "Cannot find column 'code' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String firstname() {
        return null;
    }

    @Override
    public String lastname() {
        return null;
    }

    @Override
    public int blunts() {
        return 0;
    }

    @Override
    public int period() {
        return 0;
    }

    @Override
    public String nickname() {
        return null;
    }

    @Override
    public String link() {
        return null;
    }
}
