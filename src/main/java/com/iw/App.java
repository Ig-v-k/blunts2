package com.iw;

import com.iw.page.HomePage;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public final class App {
    public static void main(final String[] args) {
        Javalin.create()
                .get("/", ctx -> ctx.html(new HomePage(persons()).content()).status(202))
                .error(404, ctx -> ctx.result("Generic 404 message"))
                .start(8080);
    }

    private static List<String> persons() {
        return new ArrayList<>() {{
            add("Arthas");
            add("Glad Valakas");
            add("Kuplinov");
        }};
    }
}
