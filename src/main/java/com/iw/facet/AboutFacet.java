package com.iw.facet;

import com.iw.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import static j2html.TagCreator.*;
import static j2html.TagCreator.b;

public final class AboutFacet implements Facet<MainTag> {
    @Override
    public Tag<MainTag> tag() {
        return main(
                img().withSrc("images/logo/logo_96.png").withWidth("70"),
                h1("Blunts2"),
                p(join(
                        b("Blunts2"),
                        "is statistic with the number of failed attempts to complete the game.")
                )
        );
    }
}
