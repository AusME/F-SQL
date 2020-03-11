package name.ben.shepley.fsql;

import name.ben.shepley.fsql._framework.wrapper.QueryResult;
import name.ben.shepley.fsql._framework.model.Query;
import name.ben.shepley.fsql._framework.util.ResultSetUtil;

import java.sql.*;

public abstract class Database {
    public abstract Connection getConnection();
    public abstract void init();

    public QueryResult executeQuery(Query query) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query.toSql());
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        return ResultSetUtil.toTable(resultSet);
    }
}
