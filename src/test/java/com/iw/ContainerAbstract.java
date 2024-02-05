package com.iw;

import com.iw.connection.PgContainer;
import org.junit.Before;

public class ContainerAbstract {

    protected Container container;

    @Before
    public void initialize() {
        container = new PgContainer("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }
}
