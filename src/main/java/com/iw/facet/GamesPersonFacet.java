package com.iw.facet;

import com.iw.Facet;
import com.iw.Game;
import com.iw.Games;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import java.util.Date;
import java.util.List;

import static j2html.TagCreator.*;

public final class GamesPersonFacet implements Facet<DivTag> {

    private final Games games;

    public GamesPersonFacet(Games games) {
        this.games = games;
    }

    @Override
    public Tag<DivTag> tag() {
        final List<Game> list = games.list();
        return div(
                each(list, (i, g) ->
                        details(
                                summary(String.format("%s. %s - %s", i, g.title(), g.blunts())),
                                each(g.attempts(), a ->
                                        p(String.format("%s - %s", new Date(a.period()), a.blunts())))
                        )));
    }
}
