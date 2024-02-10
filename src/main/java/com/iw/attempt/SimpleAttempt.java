package com.iw.attempt;

import com.iw.Attempt;
import com.iw.Container;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public final class SimpleAttempt implements Attempt {

    private final Container container;
    private final int id;
    private final int game;

    public SimpleAttempt(Container container, int id, int game) {
        this.container = container;
        this.id = id;
        this.game = game;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public int game() {
        return game;
    }

    @Override
    public int period() {
        final String query = String.format("SELECT period FROM attempt WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            rs.next();
            final int row = rs.getRow();
            if (row > 0) {
                final int period = rs.getInt("period");
                return period;
            } else {
                final String mes = String.format(
                        "Cannot find column 'period' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int blunts() {
        final String query = String.format("SELECT blunts FROM attempt WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            rs.next();
            final int row = rs.getRow();
            if (row > 0) {
                final int blunts = rs.getInt("blunts");
                return blunts;
            } else {
                final String mes = String.format(
                        "Cannot find column 'blunts' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
