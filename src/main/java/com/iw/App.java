package com.iw;

import io.javalin.Javalin;

import static j2html.TagCreator.*;

public final class App {
    public static void main(final String[] args) {
        Javalin.create()
                .get("/", ctx -> ctx.html(content()))
                .error(404, ctx -> ctx.result("Generic 404 message"))
                .start(8080);
    }

    private static String content() {
        return html(
                head(title("Blunts2")),
                body(j2html.TagCreator.main(h1("Blunts2")))
        ).render();
    }
}
