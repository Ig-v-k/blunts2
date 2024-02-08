package com.iw;

import com.iw.connection.PgContainer;
import com.iw.page.HomePage;
import com.iw.page.PersonPage;
import com.iw.persons.ByCodePersons;
import com.iw.persons.ConstPersons;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.http.staticfiles.Location;

import java.util.Collections;

public final class App {
    public static void main(final String[] args) {
        final Container c = new PgContainer("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        Javalin.create(cfg -> cfg.staticFiles.add("/assets/public", Location.CLASSPATH))
                .get("/", ctx -> ctx.html(new HomePage(new ConstPersons(c).list()).render()))
                .get("/persons/{code}", ctx -> ctx.html(
                        new PersonPage(
                                new ByCodePersons(c, Integer.parseInt(ctx.pathParam("code")))
                                        .list().get(0), Collections.emptyList()).render()))
                .error(HttpStatus.NOT_FOUND, ctx -> ctx.result("404. Page not found"))
                .start(8080);
    }
}
