package com.iw;

import io.javalin.Javalin;

public final class App {
    public static void main(final String[] args) {
        Javalin.create()
                .get("/", ctx -> ctx.result("Hello world 2 !"))
                .start(8080);
    }
}
