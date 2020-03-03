package name.ben.shepley.fsql.query.h2;

import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.framework.model.QueryStream;

import java.sql.*;

public class QueryResultsFactory {
    public QueryStream executeQuery(Connection connection, Query query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query.toSql());
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        QueryStream queryStream = new QueryStream();
        queryStream.setResultSet(resultSet);
        queryStream.setResultSetMetaData(resultSetMetaData);

        return queryStream;
    }

}
