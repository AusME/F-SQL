package name.ben.shepley.fsql.framework.util;

import name.ben.shepley.fsql.framework.model.QueryResult;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class ResultSetUtil {
    public static String toString(ResultSet resultSet) throws SQLException {
        StringBuilder rtnString = new StringBuilder();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                rtnString.append(resultSetMetaData.getColumnName(i)).append(": ").append(resultSet.getString(i));
                rtnString.append(",  ");
            }
            rtnString.delete(rtnString.length() -3, rtnString.length());
            rtnString.append("\n");
        }

        return rtnString.toString();
    }

    public static QueryResult toTable(ResultSet resultSet) throws SQLException {
        QueryResult queryResult = new QueryResult();

        Set<String> columnNames = new LinkedHashSet<>();
        Set<Integer> columnSqlTypes = new LinkedHashSet<>();
        Set<Class<?>> columnTypes = new LinkedHashSet<>();
        Set<Set<Object>> rows = new LinkedHashSet<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        /* Get Column information and first Row */
        resultSet.next();
        Set<Object> row = new LinkedHashSet<>();
        for (int col = 1; col <= resultSetMetaData.getColumnCount(); col++) {
            columnNames.add(resultSetMetaData.getColumnName(col));
            columnSqlTypes.add(resultSetMetaData.getColumnType(col));
            row.add(resultSet.getObject(col));
        }
        rows.add(row);

        /* Get all follow on rows; */
        while(resultSet.next()) {
            row = new LinkedHashSet<>();
            for (int col = 1; col <= resultSetMetaData.getColumnCount(); col++) {
                row.add(resultSet.getObject(col));
            }
            rows.add(row);
        }

        queryResult.setColumnNames(columnNames);
        queryResult.setColumnSqlTypes(columnSqlTypes);
        queryResult.setRows(rows);

        return queryResult;
    }

}
