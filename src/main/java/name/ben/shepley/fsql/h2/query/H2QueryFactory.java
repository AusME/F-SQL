package name.ben.shepley.fsql.h2.query;

import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.framework.QueryStream;

import java.sql.*;

public class H2QueryFactory {
    public static QueryStream executeQuery(Connection connection, Query query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query.toSql());
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        QueryStream queryStream = new QueryStream();
        queryStream.setResultSet(resultSet);
        queryStream.setResultSetMetaData(resultSetMetaData);

        return queryStream;
    }

}
