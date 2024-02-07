package com.iw.page;

import com.iw.Page;
import com.iw.Person;
import com.iw.facet.AboutPersonFacet;

public final class PersonPage implements Page {

    private final Person person;

    public PersonPage(final Person person) {
        this.person = person;
    }

    @Override
    public String render() {
        final String format = String.format("%s %s Statistic", person.firstname(), person.lastname());
        return new GeneralPage(
                format,
                format,
                "",
                new AboutPersonFacet(person)).render();
    }
}
