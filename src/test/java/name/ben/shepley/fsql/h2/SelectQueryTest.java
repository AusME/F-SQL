package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.framework.model.QueryResult;
import name.ben.shepley.fsql.database.connection.H2Database;
import name.ben.shepley.fsql.query.h2.QueryFactory;
import org.testng.annotations.Test;

public class SelectQueryTest {
    @Test
    public void testSelect() {
        H2Database h2Database = new H2Database();
        h2Database.init();
        try {
            QueryResult results = h2Database.executeQuery(
                QueryFactory.selectFrom()
                    .select()
                        .addColumns("*").done()
                    .from()
                        .addTables("orders").done()
            );

            System.out.println(results.as(String.class));

            //System.out.println(ResultSetUtil.toString(resultSet));
            //System.out.println(queryResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
