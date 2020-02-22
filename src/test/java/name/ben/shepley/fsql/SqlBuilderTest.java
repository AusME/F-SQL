package name.ben.shepley.fsql;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlBuilderTest {
    @Test
    public void testSelect() throws SQLException {
        SampleMySQLDatabase sampleMySQLDatabase = new SampleMySQLDatabase();
        Connection connection = SampleMySQLDatabase.getConnection();
        System.out.println("Yay!");
        connection.close();
    }
}
