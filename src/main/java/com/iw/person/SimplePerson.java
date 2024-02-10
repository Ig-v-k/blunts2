package com.iw.person;

import com.iw.Container;
import com.iw.Game;
import com.iw.Games;
import com.iw.Person;
import com.iw.game.SimpleGame;
import com.iw.games.SimpleGames;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        final String query = String.format("SELECT firstname FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            final int row = rs.getRow();
            if (row > 0) {
                final String firstname = rs.getString("firstname");
                return firstname;
            } else {
                final String mes = String.format(
                        "Cannot find column 'firstname' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String lastname() {
        final String query = String.format("SELECT lastname FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            final int row = rs.getRow();
            if (row > 0) {
                final String lastname = rs.getString("lastname");
                return lastname;
            } else {
                final String mes = String.format(
                        "Cannot find column 'lastname' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int blunts() {
        int blunts = 0;
        for (Game game : games().list()) {
            blunts += game.blunts();
        }
        return blunts;
    }

    @Override
    public int period() {
        final String query = String.format("SELECT period FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
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
    public String nickname() {
        final String query = String.format("SELECT nickname FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            final int row = rs.getRow();
            if (row > 0) {
                final String nickname = rs.getString("nickname");
                return nickname;
            } else {
                final String mes = String.format(
                        "Cannot find column 'nickname' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String link() {
        final String query = String.format("SELECT link FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            final int row = rs.getRow();
            if (row > 0) {
                final String link = rs.getString("link");
                return link;
            } else {
                final String mes = String.format(
                        "Cannot find column 'link' with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(new int[]{id}));
                throw new RuntimeException(mes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Games games() {
        return new SimpleGames(container, id);
    }
}
