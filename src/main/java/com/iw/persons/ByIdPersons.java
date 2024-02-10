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

public final class ByIdPersons implements Persons {

    private final Container container;
    private final int id;

    public ByIdPersons(Container container, int id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public List<Person> list() {
        final List<Person> persons = new ArrayList<>();
        final String query = String.format("SELECT * FROM person WHERE id = %s", id);
        try (final Statement st = container.conn().createStatement();
             final ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
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
                        games);
                persons.add(cnst);
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
