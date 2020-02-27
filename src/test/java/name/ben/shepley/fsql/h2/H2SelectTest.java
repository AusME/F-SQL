package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.database.connection.H2Database;
import name.ben.shepley.fsql.framework.QueryStream;
import name.ben.shepley.fsql.h2.query.H2QueryFactory;
import name.ben.shepley.fsql.h2.query.H2Select;
import org.testng.annotations.Test;

import java.sql.*;

public class H2SelectTest {
    @Test
    public void testSelect() {
        H2Database.init();
        try (Connection connection = H2Database.getConnection()) {
            QueryStream results = H2QueryFactory.createSelectQuery()
                    .select()
                        .select("*").done()
                        .from().from("orders").done()
                    .execute();


//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(selectOrders.toSql());
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//
//            int columnsNumber = rsmd.getColumnCount();
//            while (statement.getResultSet().next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = resultSet.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }
//                System.out.println();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
