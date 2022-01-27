package com.udacity.lesson01.exercise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.flywaydb.core.Flyway;
import org.tinylog.Logger;

public class Application {

    public static void main(String[] args) {
        // STEP 1: Create the JDBC URL for JDND-C3 database
        String url = "jdbc:mysql://localhost:3306/jdnd_c3?useSSL=false";
        String username = "root";
        String password = "root";

        // STEP 2: Setup and Run Flyway migration that creates the member table using its Java API
        // https://flywaydb.org/getstarted/firststeps/api#integrating-flyway
        // Note the above link talks about connecting to H2 database, for this exercise, MySQL is used. Adapt the code accordingly.

        Flyway flyway = Flyway.configure()
                .dataSource(url, username, password)
                .load();

        flyway.migrate();
        Logger.info("Flyway Migrated");

        // STEP 3: Obtain a connection to the JDND-C3 database
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Logger.info("Connected " + connection.getMetaData().getDatabaseProductName());
        } catch (SQLException e) {
            Logger.error(e);
        }
        // STEP 4: Use Statement to INSERT 2 records into the member table
        // NOTE: The member table is created using Flyway by placing the migration file in src/main/resources/db/migration

        // STEP 5: Read ALL the rows from the member table and print them here

        // STEP 6: verify that all inserted rows have been printed
    }

}