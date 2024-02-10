package com.iw.persons;

import com.iw.Container;
import com.iw.Person;
import com.iw.Persons;
import com.iw.games.ConstGames;
import com.iw.person.ConstPerson;
import com.iw.person.SimplePerson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class ByNicknamePersons implements Persons {

    private final Container container;
    private final String nickname;

    public ByNicknamePersons(Container container, String nickname) {
        this.container = container;
        this.nickname = nickname;
    }

    @Override
    public List<Person> list() {
        final List<Person> persons = new ArrayList<>();
        final String query = String.format("SELECT * FROM person WHERE nickname = '%s'", nickname);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                final int id = rs.getInt("id");
                final Person simple = new SimplePerson(container, id);
                final ConstGames games = new ConstGames(container, id);
                final Person cnst = new ConstPerson(
                        simple,
                        rs.getInt("code"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("period"),
                        rs.getString("nickname"),
                        rs.getString("link"),
                        games
                );
                persons.add(cnst);
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
