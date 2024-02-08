package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.SectionTag;

import static j2html.TagCreator.header;
import static j2html.TagCreator.section;

public final class ContentPersonFacet implements Facet<SectionTag> {

    private final Person person;

    public ContentPersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<SectionTag> tag() {
        return section(
                header(new AboutPersonFacet(person).tag()),
                main(new GamesPersonFacet(person.id()).tag())
        );
    }
}
