package com.iw.page;

import com.iw.Facet;
import com.iw.Page;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeaderTag;

import static j2html.TagCreator.*;

public final class GeneralPage implements Page {

    private static String ttl = "";
    private static String desc = "";
    private final Facet facet;

    public GeneralPage(Facet facet) {
        this("", "", facet);
    }

    public GeneralPage(final String ttl, final String desc, Facet facet) {
        GeneralPage.ttl = ttl;
        GeneralPage.desc = desc;
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
                        link().withRel("stylesheet").withHref("/css/simple.min.css"),
                        link().withRel("icon").withType("image/png").withHref("/images/logo/logo_32.png")
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
                nav(
                        a("Home").withHref("/"),
                        a("Github").withHref("https://github.com/Ig-v-k/blunts2")
                ),
                ttl.isEmpty() ? emptyTag("h1") : h1(ttl),
                desc.isEmpty() ? emptyTag("p") : p(desc)
        );
    }

    private static FooterTag ftr() {
        return footer(
                p(join("Made by ", a("@Ig-v-k").withHref("https://github.com/Ig-v-k"), ", 2024")),
                nav(a("GitHub").withHref("https://github.com/Ig-v-k/blunts2"))
        );
    }
}
