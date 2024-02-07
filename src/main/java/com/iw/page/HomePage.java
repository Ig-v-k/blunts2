package com.iw.page;

import com.iw.Page;
import com.iw.Person;
import com.iw.facet.PersonsSectionFacet;

import java.util.List;

public final class HomePage implements Page {

    private final List<Person> persons;

    public HomePage(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String render() {
        return new GeneralPage(
                "Blunts2 Statistic",
                "Blunts2 is statistic with the number of failed attempts to complete the game.",
                new PersonsSectionFacet(persons)).render();
    }
}
