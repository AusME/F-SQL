package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.database.connection.H2Database;
import name.ben.shepley.fsql.framework.QueryStream;
import name.ben.shepley.fsql.h2.query.H2QueryFactory;
import name.ben.shepley.fsql.h2.query.select.FluentSelectQuery;
import org.testng.annotations.Test;

import java.sql.*;

public class SelectQueryTest {
    @Test
    public void testSelect() {
        H2Database.init();
        try (Connection connection = H2Database.getConnection()) {
            QueryStream results = H2QueryFactory.executeQuery(connection, new FluentSelectQuery()
                    .select()
                        .addColumns("*").done()
                    .from()
                        .addTables("orders").done()
            );

            ResultSet resultSet = results.getResultSet();
            ResultSetMetaData resultSetMetaData = results.getResultSetMetaData();

            int columnsNumber = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    System.out.print(resultSetMetaData.getColumnName(i) + ": " + resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
