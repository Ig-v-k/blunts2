package com.iw;

import com.iw.page.HomePage;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class App {
    public static void main(final String[] args) {
        Javalin.create(cfg ->
                        cfg.staticFiles.add("/assets", Location.CLASSPATH))
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
