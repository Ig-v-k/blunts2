package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import static j2html.TagCreator.*;

public final class AboutPersonFacet implements Facet<MainTag> {

    private final Person person;

    public AboutPersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<MainTag> tag() {
        final String nickname = person.nickname();
        return main(
                h1(nickname),
                p());
    }
}
