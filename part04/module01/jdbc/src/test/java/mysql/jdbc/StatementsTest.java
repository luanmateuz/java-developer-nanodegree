package mysql.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatementsTest {

    private final Statements statements = new Statements();

    @Test
    void statementMethod() {
        boolean result = statements.statementMethod();

        assertTrue(result, "Executed");
    }

    @Test
    void preparedStatementMethod() {
        boolean result = statements.preparedStatementMethod(1, "Luan");

        assertTrue(result, "Executed");
    }
}