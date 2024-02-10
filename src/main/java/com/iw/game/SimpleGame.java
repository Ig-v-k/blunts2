package com.iw.game;

import com.iw.Attempts;
import com.iw.Container;
import com.iw.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public final class SimpleGame implements Game {

    private final Container container;
    private final int id;

    public SimpleGame(Container container, int id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public int person() {
        final String query = String.format("SELECT person FROM game WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            rs.next();
            final int row = rs.getRow();
            if (row > 0) {
                final int person = rs.getInt("person");
                return person;
            } else {
                final String mes = String.format(
                        "Cannot find column 'person' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String title() {
        final String query = String.format("SELECT title FROM game WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            final int row = rs.getRow();
            if (row > 0) {
                final String title = rs.getString("title");
                return title;
            } else {
                final String mes = String.format(
                        "Cannot find column 'title' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int blunts() {
        final String query = String.format("SELECT blunts FROM game WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
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

    @Override
    public Attempts attempts() {
        return null;
    }
}
