package com.iw.attempts;

import com.iw.Attempt;
import com.iw.Attempts;
import com.iw.Container;
import com.iw.attempt.ConstAttempt;
import com.iw.attempt.SimpleAttempt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class ConstAttempts implements Attempts {

    private final Container container;
    private final int game;

    public ConstAttempts(Container container, int game) {
        this.container = container;
        this.game = game;
    }

    @Override
    public List<Attempt> list() {
        final List<Attempt> persons = new ArrayList<>();
        final String query = String.format("SELECT * FROM attempt WHERE game = %s", game);
        try (final Connection conn = container.conn();
             final Statement st = conn.createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                final int id = rs.getInt("id");
                final SimpleAttempt simple = new SimpleAttempt(container, id, game);
                persons.add(new ConstAttempt(
                        simple,
                        game,
                        rs.getInt("period"),
                        rs.getInt("blunts")));
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
