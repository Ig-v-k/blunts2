package com.iw;

import com.iw.page.HomePage;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.ArrayList;
import java.util.List;

public final class App {

    private static final List<String> persons = new ArrayList<>() {{
        add("Arthas");
        add("Glad Valakas");
        add("Kuplinov");
    }};

    public static void main(final String[] args) {
        final Javalin app = Javalin.create(cfg ->
                        cfg.staticFiles.add("/assets", Location.CLASSPATH))
                .get("/", ctx -> ctx.html(new HomePage(persons).content()).status(202))
                .error(404, ctx -> ctx.result("Generic 404 message"));
        for (String person : persons) {
            final String formatted = person;
            app.get("/" + person, ctx -> ctx.html(new PersonPage(person).content()).status(202));
        }
        app.start(8080);
    }
}
