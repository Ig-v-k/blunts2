package com.iw.facet;

import com.iw.Facet;
import com.iw.Game;
import com.iw.Person;
import j2html.tags.Tag;
import j2html.tags.specialized.SectionTag;

import java.util.List;

import static j2html.TagCreator.*;

public final class ContentPersonFacet implements Facet<SectionTag> {

    private final Person person;

    private final List<Game> games;

    public ContentPersonFacet(Person person, List<Game> games) {
        this.person = person;
        this.games = games;
    }

    @Override
    public Tag<SectionTag> tag() {
        return section(
                header(new AboutPersonFacet(person).tag()),
                main(new GamesPersonFacet(games).tag())
        );
    }
}
