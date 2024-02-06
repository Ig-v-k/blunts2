package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.TableTag;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

public final class PersonsTableFacet implements Facet<TableTag> {

    private final List<Person> persons;

    public PersonsTableFacet(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public Tag<TableTag> tag() {
        final List<String> headers = new ArrayList<>() {{
            add("Streamer");
            add("Blunts");
        }};
        return table(
                thead(
                        tr(
                                each(headers, s -> th(s)))),
                tbody(
                        each(
                                persons, p -> tr(
                                        td(a(p.nickname()).withHref("/persons/" + p.code())),
                                        td("0"))))
        );
    }
}
