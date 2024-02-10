package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.*;

public final class ContentPersonFacet implements Facet<DivTag> {

    private final Person person;

    public ContentPersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<DivTag> tag() {
        return div(
                header(h3("Games")),
                main(new GamesPersonFacet(person.games()).tag())
        );
    }
}
