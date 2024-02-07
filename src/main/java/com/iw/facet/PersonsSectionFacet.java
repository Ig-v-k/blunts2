package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;
import j2html.tags.specialized.TableTag;

import java.util.List;

import static j2html.TagCreator.*;

public final class PersonsSectionFacet implements Facet<MainTag> {

    private final List<Person> persons;

    public PersonsSectionFacet(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public Tag<MainTag> tag() {
        final Facet<TableTag> table = new PersonsTableFacet(persons);
        return main(
                h2("Persons"),
                p("General statistics of persons."),
                table.tag()
        );
    }
}
