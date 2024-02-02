package com.iw;

import com.iw.page.HomePage;
import com.iw.page.PersonPage;
import com.iw.page.PersonsPage;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.http.staticfiles.Location;

public final class App {
    public static void main(final String[] args) {
        Javalin.create(cfg -> cfg.staticFiles.add("/assets/public", Location.CLASSPATH))
                .get("/", ctx -> ctx.html(new HomePage().render()))
                .get("/persons", ctx -> ctx.html(new PersonsPage().render()))
                .get("/persons/{id}", ctx -> ctx.html(new PersonPage(ctx.pathParam("id")).render()))
                .error(HttpStatus.NOT_FOUND, ctx -> ctx.result("404. Page not found"))
                .start(8080);
    }
}
