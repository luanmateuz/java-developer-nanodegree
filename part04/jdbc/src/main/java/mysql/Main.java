package mysql;

import java.sql.SQLException;
import mysql.jdbc.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        LOGGER.info("Connected {}",
                Connector.getConnection().getMetaData().getDatabaseProductName());
    }
}
