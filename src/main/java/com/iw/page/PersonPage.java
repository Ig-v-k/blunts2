package com.iw.page;

import com.iw.Page;
import com.iw.Person;
import com.iw.facet.ContentPersonFacet;

import java.util.Date;

public final class PersonPage implements Page {

    private final Person person;

    public PersonPage(final Person person) {
        this.person = person;
    }

    @Override
    public String render() {
        final String format = String.format("%s %s", person.firstname(), person.lastname());
        final String description = String.format("%s • %s • %s",
                person.nickname(), new Date(person.period()), "Russia, Samara");
        return new GeneralPage(format, format, description, new ContentPersonFacet(person)).render();
    }
}
