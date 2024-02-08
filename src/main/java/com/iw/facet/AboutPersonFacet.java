package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import java.util.Date;

import static j2html.TagCreator.*;

public final class AboutPersonFacet implements Facet<MainTag> {

    private final Person person;

    public AboutPersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<MainTag> tag() {
        final String headline = String.format("%s %s", person.firstname(), person.lastname());
        final String subtitle = String.format("%s • %s • %s",
                person.nickname(), new Date(person.period()), "Russia, Samara");
        return main(
                h2(headline),
                p(subtitle));
    }
}
