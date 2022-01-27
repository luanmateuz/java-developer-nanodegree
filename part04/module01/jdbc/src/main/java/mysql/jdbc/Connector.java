package mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connector {

    private static final Logger LOGGER = LoggerFactory.getLogger(Connector.class);

    public static Connection getConnection() {
        try {
            String databaseName = "jdbc:mysql://localhost/blog";
            String databaseUser = "root";
            String databasePassword = "root";

            return DriverManager.getConnection(databaseName, databaseUser, databasePassword);
        } catch (SQLException exception) {
            LOGGER.error("SQLException: {}", exception.getMessage());
            LOGGER.error("SQLState: {}", exception.getSQLState());
            LOGGER.error("VendorError: {}", exception.getErrorCode());
            return null;
        }
    }
}
