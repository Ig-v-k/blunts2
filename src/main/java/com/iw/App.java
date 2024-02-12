package com.iw;

import com.iw.container.PGHikariSingleton;
import com.iw.jdbc.EnvJDBC;
import com.iw.page.HomePage;
import com.iw.page.PersonPage;
import com.iw.persons.ByNicknamePersons;
import com.iw.persons.ConstPersons;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.http.staticfiles.Location;

import java.util.logging.Logger;

public final class App {
    public static void main(final String[] args) {
        final Logger log = Logger.getLogger("App");
        final Container c = new PGHikariSingleton(new EnvJDBC());
        final Javalin app = Javalin.create(cfg -> {
                    cfg.events(ecfg -> {
                        ecfg.serverStarting(() -> log.info("server starting"));
                        ecfg.serverStarted(() -> log.info("server started"));
                        ecfg.serverStopping(() -> log.info("server stopping"));
                        ecfg.serverStopped(() -> log.info("server stopped"));
                    });
                    cfg.staticFiles.add("/assets/public", Location.CLASSPATH);
                })
                .get("/", ctx -> ctx.html(new HomePage(new ConstPersons(c).list()).render()))
                .get("/{nickname}", ctx -> {
                    final Person person = new ByNicknamePersons(c, ctx.pathParam("nickname")).list().get(0);
                    ctx.html(new PersonPage(person).render());
                })
                .error(HttpStatus.NOT_FOUND, ctx -> ctx.result("404. Page not found"));
        Runtime.getRuntime().addShutdownHook(new Thread(app::stop));
        app.start(port());
    }

    private static int port() {
        final ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }
}
