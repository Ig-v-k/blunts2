package com.iw;

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

    @Test(expected = NullPointerException.class)
    public void npe() {
        new SimplePersons(null).list();
    }
}
