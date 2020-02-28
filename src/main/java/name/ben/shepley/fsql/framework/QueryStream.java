package name.ben.shepley.fsql.framework;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class QueryStream {
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public ResultSet getResultSet() {
        return resultSet;
    }
    public QueryStream setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
        return this;
    }

    public ResultSetMetaData getResultSetMetaData() {
        return resultSetMetaData;
    }

    public QueryStream setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
        this.resultSetMetaData = resultSetMetaData;
        return this;
    }
}
