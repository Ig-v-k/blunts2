package com.iw.facet;

import com.iw.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;
import j2html.tags.specialized.TableTag;

import java.util.List;

import static j2html.TagCreator.*;

public final class PersonsSectionFacet implements Facet<MainTag> {

    private final List<String> persons;

    public PersonsSectionFacet(List<String> persons) {
        this.persons = persons;
    }

    @Override
    public Tag<MainTag> tag() {
        final Facet<TableTag> table = new PersonsTableFacet(persons);
        return main(
                h1("Persons"),
                p("Page with general statistics of persons."),
                table.tag()
        );
    }
}
