package com.iw;

import com.iw.page.HomePage;
import io.javalin.Javalin;

import static j2html.TagCreator.*;

public final class App {
    public static void main(final String[] args) {
        Javalin.create()
                .get("/", ctx -> ctx.html(new HomePage().content()))
                .error(404, ctx -> ctx.result("Generic 404 message"))
                .start(8080);
    }
}
