package com.iw.facet;

import com.iw.Facet;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import java.util.Date;

import static j2html.TagCreator.*;

public final class AboutPersonFacet implements Facet<DivTag> {

    private final Person person;

    public AboutPersonFacet(Person person) {
        this.person = person;
    }

    @Override
    public Tag<DivTag> tag() {
        final String headline = String.format("%s %s", person.firstname(), person.lastname());
        final String subtitle = String.format("%s • %s • %s",
                person.nickname(), new Date(person.period()), "Russia, Samara");
        return div(
                h2(headline),
                p(subtitle));
    }
}
