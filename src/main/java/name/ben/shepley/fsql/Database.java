package name.ben.shepley.fsql;

import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.framework.model.QueryStream;

import java.sql.*;

public class Database {
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
