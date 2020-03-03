package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.query.h2.QueryResultsFactory;
import name.ben.shepley.fsql.database.connection.H2Database;
import name.ben.shepley.fsql.framework.model.QueryResult;
import name.ben.shepley.fsql.framework.model.QueryStream;
import name.ben.shepley.fsql.framework.util.ResultSetUtil;
import name.ben.shepley.fsql.query.h2.QueryFactory;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;

public class SelectQueryTest {
    @Test
    public void testSelect() {
        H2Database.init();
        try (Connection connection = H2Database.getConnection()) {
            QueryResultsFactory queryResultsFactory = new QueryResultsFactory();
            QueryStream results = queryResultsFactory.executeQuery(connection, QueryFactory.selectFrom()
                    .select()
                        .addColumns("*").done()
                    .from()
                        .addTables("orders").done()
            );

            ResultSet resultSet = results.getResultSet();
            QueryResult queryResult = ResultSetUtil.toTable(resultSet);

            //System.out.println(ResultSetUtil.toString(resultSet));
            System.out.println(queryResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
