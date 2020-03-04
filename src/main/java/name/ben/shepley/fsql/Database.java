package name.ben.shepley.fsql;

import name.ben.shepley.fsql.framework.model.DataStream;
import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.framework.model.QueryResult;
import name.ben.shepley.fsql.framework.util.ResultSetUtil;

import java.sql.*;

public abstract class Database {
    public abstract Connection getConnection();
    public abstract void init();

    public <T> DataStream<?> executeQuery(T t, Query query) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query.toSql());
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        QueryResult queryResult = ResultSetUtil.toTable(resultSet);
        return DataStream.of(queryResult);
    }

}
