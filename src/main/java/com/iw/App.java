package com.iw;

import com.iw.page.HomePage;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
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
        Javalin.create(cfg -> cfg.staticFiles.add("/assets/public", Location.CLASSPATH))
                .get("/", ctx -> ctx.html(new HomePage(persons).content()))
                .get("/users", ctx -> ctx.html(new PersonsPage().content()))
                .get("/users/{id}", ctx -> ctx.html(new PersonPage(ctx.pathParam("id")).content()))
                .error(HttpStatus.NOT_FOUND, ctx -> ctx.result("404. Page not found"))
                .start(8080);
    }
}
