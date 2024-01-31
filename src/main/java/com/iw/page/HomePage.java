package com.iw.page;

import com.iw.Page;

import static j2html.TagCreator.*;

public final class HomePage implements Page {
    @Override
    public String content() {
        return html(
                head(title("Blunts2")),
                body(j2html.TagCreator.main(h1("Blunts2")))
        ).render();
    }
}
