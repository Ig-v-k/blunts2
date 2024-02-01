package com.iw.page;

import com.iw.Page;

import java.util.List;

import static j2html.TagCreator.*;

public final class HomePage implements Page {

    private final List<String> persons;

    public HomePage(List<String> persons) {
        this.persons = persons;
    }

    @Override
    public String content() {
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
                        header(
                                img().withSrc("images/logo/logo_96.png").withWidth("70"),
                                h1("Blunts2"),
                                p(join(
                                        b("Blunts2"),
                                        "is statistic with the number of failed attempts to complete the game.")
                                )
                        ),
                        main(
                                p("content")
                        ),
                        footer(
                                p(join(
                                        "Made by ",
                                        a("@Ig-v-k").withHref("https://github.com/Ig-v-k"),
                                        ", 2024"
                                )),
                                nav(ul(li(a("GitHub").withHref("https://github.com/Ig-v-k/blunts2"))))
                        )
                )
        ).render();
    }
}
