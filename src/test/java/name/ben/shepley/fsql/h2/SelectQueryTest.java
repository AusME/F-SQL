package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.Database;
import name.ben.shepley.fsql.database.connection.H2Database;
import name.ben.shepley.fsql.framework.dataStructure.Table;
import name.ben.shepley.fsql.framework.model.QueryStream;
import name.ben.shepley.fsql.framework.util.ResultSetUtil;
import name.ben.shepley.fsql.h2.query.select.FluentSelectQuery;
import org.testng.annotations.Test;

import java.sql.*;

public class SelectQueryTest {
    @Test
    public void testSelect() {
        H2Database.init();
        try (Connection connection = H2Database.getConnection()) {
            Database database = new Database();
            QueryStream results = database.executeQuery(connection, FluentSelectQuery.selectFrom()
                    .select()
                        .addColumns("*").done()
                    .from()
                        .addTables("orders").done()
            );

            ResultSet resultSet = results.getResultSet();
            Table table = ResultSetUtil.toTable(resultSet);

            //System.out.println(ResultSetUtil.toString(resultSet));
            System.out.println(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
