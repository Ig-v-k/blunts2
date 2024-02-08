package com.iw.facet;

import com.iw.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.TableTag;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

public final class GamesPersonFacet implements Facet<TableTag> {

    private final List<Game> games;

    @Override
    public Tag<TableTag> tag() {
        final List<String> headers = new ArrayList<>() {{
            add("Game");
            add("Blunts");
        }};
        return table(
                thead(
                        tr(
                                each(headers, s -> th(s)))),
                tbody(
                        each(
                                games, g -> tr(
                                        td(g.title()),
                                        td(String.valueOf(g.blunts())))))
        );
    }
}
