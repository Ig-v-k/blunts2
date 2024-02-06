package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.SectionTag;

import static j2html.TagCreator.h1;
import static j2html.TagCreator.section;

public final class PersonFacet implements Facet<SectionTag> {

    private final Person person;

    public PersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<SectionTag> tag() {
        final String nickname = person.nickname();
        return section(h1(nickname));
    }
}
