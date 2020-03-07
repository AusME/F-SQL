package name.ben.shepley.fsql.framework.util;

import name.ben.shepley.fsql.framework.model.QueryResult;
import name.ben.shepley.fsql.framework.model.TabularData;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

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

    public static QueryResult<TabularData> toTable(ResultSet resultSet) throws SQLException {
        Map<String, Class<?>> columns = new LinkedHashMap<>();
        List<List<Object>> rows = new LinkedList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        /* Get Column information and first Row */
        resultSet.next();
        List<Object> row = new LinkedList<>();
        for (int col = 1; col <= resultSetMetaData.getColumnCount(); col++) {
            /*TODO: TRANSLATE TYPE */
            columns.put(resultSetMetaData.getColumnName(col), String.class);
            row.add(resultSet.getObject(col));
        }
        rows.add(row);

        /* Get all follow on rows; */
        while(resultSet.next()) {
            row = new LinkedList<>();
            for (int col = 1; col <= resultSetMetaData.getColumnCount(); col++) {
                row.add(resultSet.getObject(col));
            }
            rows.add(row);
        }

        return new QueryResult<>(new TabularData.TabularDataBuilder().setColumns(columns).setRows(rows).build());
    }

}
