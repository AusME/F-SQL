package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.framework.model.DataStream;
import name.ben.shepley.fsql.database.connection.H2Database;
import name.ben.shepley.fsql.query.h2.QueryFactory;
import org.testng.annotations.Test;

import java.sql.Connection;

public class SelectQueryTest {
    @Test
    public void testSelect() {
        H2Database h2Database = new H2Database();
        h2Database.init();
        try (Connection connection = h2Database.getConnection()) {

            DataStream<?> results = h2Database.executeQuery(connection, QueryFactory.selectFrom()
                    .select()
                        .addColumns("*").done()
                    .from()
                        .addTables("orders").done()
            );

            System.out.println(results.getAs(String.class));

            //System.out.println(ResultSetUtil.toString(resultSet));
            //System.out.println(queryResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
