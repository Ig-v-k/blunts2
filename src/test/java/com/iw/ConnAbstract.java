package com.iw;

import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnAbstract {

    protected Connection con;

    @Before
    public void initialize() throws SQLException {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        con.setSchema("public");
        con.setAutoCommit(false);
    }
}
