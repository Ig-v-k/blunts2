package com.iw;

import com.iw.persons.ByCodePersons;
import com.iw.persons.ByIdPersons;
import com.iw.persons.ConstPersons;
import com.iw.persons.SimplePersons;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class PersonsTest extends ContainerAbstract {
    @Test
    public void simple() {
        final List<Person> persons = new SimplePersons(container).list();
        assertThat(persons).isNotEmpty();
    }

    @Test
    public void cnst() {
        final List<Person> persons = new ConstPersons(container).list();
        assertThat(persons).isNotEmpty();
    }

    @Test(expected = NullPointerException.class)
    public void npe() {
        new SimplePersons(null).list();
    }

    @Test
    public void byId() {
        final List<Person> list = new ByIdPersons(container, 0).list();
        assertThat(list).isNotEmpty().hasSize(1);
    }

    @Test
    public void byCode() {
        final List<Person> list = new ByCodePersons(container, 100).list();
        assertThat(list).isNotEmpty().hasSize(1);
    }
}
