package com.iw.page;

import com.iw.Page;
import com.iw.Person;
import com.iw.facet.PersonsSectionFacet;

import java.util.List;

public final class PersonsPage implements Page {

    private final List<Person> persons;

    public PersonsPage(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String render() {
        return new GeneralPage(new PersonsSectionFacet(persons)).render();
    }
}
