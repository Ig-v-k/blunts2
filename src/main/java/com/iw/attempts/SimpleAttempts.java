package com.iw.attempts;

import com.iw.Attempt;
import com.iw.Attempts;
import com.iw.Container;
import com.iw.Person;
import com.iw.attempt.SimpleAttempt;
import com.iw.person.SimplePerson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class SimpleAttempts implements Attempts {

    private final Container container;
    private final int game;

    public SimpleAttempts(Container container, int game) {
        this.container = container;
        this.game = game;
    }

    @Override
    public List<Attempt> list() {
        final List<Attempt> persons = new ArrayList<>();
        final String query = String.format("SELECT * FROM attempt WHERE game = %s", game);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                final int id = rs.getInt("id");
                persons.add(new SimpleAttempt(container, id, game));
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
