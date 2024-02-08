package com.iw.facet;

import com.iw.Facet;
import com.iw.Game;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import java.util.Date;
import java.util.List;

import static j2html.TagCreator.*;

public final class GamesPersonFacet implements Facet<DivTag> {

    private final List<Game> games;

    public GamesPersonFacet(List<Game> games) {
        this.games = games;
    }

    @Override
    public Tag<DivTag> tag() {
        return div(
                each(games, (i, g) ->
                        details(
                                summary(g.title()),
                                each(g.attempts(), a -> {
                                    p(String.format("%s - %s", new Date(a.period()), a.blunts()));
                                })
                        )));
    }
}
