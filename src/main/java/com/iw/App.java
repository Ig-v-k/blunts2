package com.iw;

import com.iw.connection.PgContainer;
import com.iw.page.HomePage;
import com.iw.page.PersonPage;
import com.iw.page.PersonsPage;
import com.iw.persons.ByIdPersons;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.http.staticfiles.Location;

public final class App {
    public static void main(final String[] args) {
        final Container c = new PgContainer("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        Javalin.create(cfg -> cfg.staticFiles.add("/assets/public", Location.CLASSPATH))
                .get("/", ctx -> ctx.html(new HomePage().render()))
                .get("/persons", ctx -> ctx.html(new PersonsPage().render()))
                .get("/persons/{code}", ctx -> ctx.html(
                        new PersonPage(
                                new ByIdPersons(c, Integer.parseInt(ctx.pathParam("code")))
                                        .list().get(0)).render()))
                .error(HttpStatus.NOT_FOUND, ctx -> ctx.result("404. Page not found"))
                .start(8080);
    }
}
