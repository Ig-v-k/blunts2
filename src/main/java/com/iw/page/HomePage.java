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
                head(title("Blunts2")),
                body(
                        main(
                                section(
                                        header(
                                                h1("Blunts2"),
                                                p(join(
                                                        b("Blunts2"),
                                                        "is statistic with the number of failed attempts to complete the game.")
                                                ),
                                                nav(
                                                        ul(
                                                                each(persons, person ->
                                                                        li(
                                                                                a(person).withHref("/" + person)
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        ).render();
    }
}
