package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import com.iw.connection.PgContainer;
import j2html.TagCreator;
import j2html.tags.Tag;
import j2html.tags.specialized.SectionTag;

import static j2html.TagCreator.*;

public final class ContentPersonFacet implements Facet<SectionTag> {

    private final Person person;

    public ContentPersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<SectionTag> tag() {
        return section(
                header(new AboutPersonFacet(person).tag()),
                main(new GamesPersonFacet().tag())
        );
    }
}
