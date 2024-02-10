package com.iw.games;

import com.iw.Container;
import com.iw.Game;
import com.iw.Games;
import com.iw.game.SimpleGame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class SimpleGames implements Games {

    private final Container container;
    private final int id;

    public SimpleGames(Container container, int id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public List<Game> list() {
        final List<Game> games = new ArrayList<>();
        final String query = String.format("SELECT * FROM game WHERE person = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                final int id = rs.getInt("id");
                games.add(new SimpleGame(container, id));
            }
            return games;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}