package mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Statements {

    private static final Logger LOGGER = LoggerFactory.getLogger(Statements.class);
    private final Connection connection = Connector.getConnection();

    public boolean statementMethod() {
        try (Statement statement = connection.createStatement()) {
            int exec = statement.executeUpdate(
                    "CREATE TABLE EMPLOYEE (EMP_ID INT NOT NULL, EMP_NAME VARCHAR(255))");
            LOGGER.info("Statement executed: {}", exec);
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQLException: {}", e.getMessage());
            return false;
        }
    }

    public boolean preparedStatementMethod(int id, String name) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "update EMPLOYEE set EMP_NAME = ? where EMP_ID = ?");
            pstmt.setString(1, name);
            pstmt.setInt(2, id);

            int exec = pstmt.executeUpdate();
            LOGGER.info("PreparedStatement executed: {}", exec);
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQLException: {}", e.getMessage());
            return false;
        }
    }
}
