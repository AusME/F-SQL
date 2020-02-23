package name.ben.shepley.fsql.database.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDatabase {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:ben;";
    private static final String DB_OPTIONS = "DB_CLOSE_DELAY=-1;DATABASE_TO_LOWER=TRUE;IGNORECASE=TRUE";

    private static final String USER = "sa";
    private static final String PASS = "";

    public static void init() {
        MySQLDatabase.setupDatabase();
    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL + DB_OPTIONS, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database.");
        }
    }

    private static void setupDatabase() {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            String sql = getDatabaseSchemaAndData();
            statement.executeUpdate(sql);

            connection.commit();
            statement.close();
            connection.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    private static String getDatabaseSchemaAndData() {
        Class<MySQLDatabase> clazz = MySQLDatabase.class;
        InputStream inputStream = clazz.getResourceAsStream("/SampleMySQlDatabase.sql");

        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to find Sample Database.");
        }

        return resultStringBuilder.toString();
    }
}