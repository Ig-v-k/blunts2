package com.iw;

import com.iw.connection.PgContainer;
import org.junit.Before;

import java.sql.SQLException;

public class ContainerAbstract {

    protected Container container;

    @Before
    public void initialize() throws SQLException {
        container = new PgContainer("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }
}
