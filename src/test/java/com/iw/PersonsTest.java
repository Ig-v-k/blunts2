package com.iw;

import com.iw.connection.PgContainer;
import com.iw.persons.SimplePersons;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class PersonsTest extends ConnAbstract {
    @Test
    public void simple() throws SQLException {
        final List<Person> persons =
                new SimplePersons(container)).list();
        assertThat(persons).isNotEmpty();
    }
}
