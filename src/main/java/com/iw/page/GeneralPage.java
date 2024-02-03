package com.iw.page;

import com.iw.Facet;
import com.iw.Page;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeaderTag;

import static j2html.TagCreator.*;

public final class GeneralPage implements Page {

    private final Facet facet;

    public GeneralPage(Facet facet) {
        this.facet = facet;
    }

    @Override
    public String render() {
        return html(
                head(
                        meta().withCharset("UTF-8"),
                        meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                        meta().withName("keywords").withContent("streamers, statistic, rating, twitch"),
                        meta().withName("description").withContent("Streamers failed statistic"),
                        title("Blunts2"),
                        link().withRel("stylesheet").withHref("css/simple.min.css"),
                        link().withRel("icon").withType("image/png").withHref("images/logo/logo_32.png")
                ),
                body(
                        hdr(),
                        facet.tag(),
                        ftr()
                )
        ).render();
    }

    private static HeaderTag hdr() {
        return header(
                img().withSrc("images/logo/logo_96.png").withWidth("70"),
                nav(
                        a("Home").withHref("/"),
                        a("Persons").withHref("/persons")
                )
        );
    }

    private static FooterTag ftr() {
        return footer(
                p(join("Made by ", a("@Ig-v-k").withHref("https://github.com/Ig-v-k"), ", 2024")),
                nav(a("GitHub").withHref("https://github.com/Ig-v-k/blunts2"))
        );
    }
}
