package name.ben.shepley.fsql.framework.dataStructure;

import java.util.LinkedHashSet;
import java.util.Set;

public class Table {
    Set<String> columnNames = new LinkedHashSet<>();
    Set<Integer> columnSqlTypes = new LinkedHashSet<>();
    Set<Class<?>> columnTypes = new LinkedHashSet<>();
    Set<Set<Object>> rows = new LinkedHashSet<>();

    public Set<String> getColumnNames() {
        return columnNames;
    }
    public void setColumnNames(Set<String> columnNames) {
        this.columnNames = columnNames;
    }

    public Set<Integer> getColumnSqlTypes() {
        return columnSqlTypes;
    }
    public void setColumnSqlTypes(Set<Integer> columnSqlTypes) {
        this.columnSqlTypes = columnSqlTypes;
    }

    public Set<Class<?>> getColumnTypes() {
        return columnTypes;
    }
    public void setColumnTypes(Set<Class<?>> columnTypes) {
        this.columnTypes = columnTypes;
    }

    public Set<Set<Object>> getRows() {
        return rows;
    }
    public void setRows(Set<Set<Object>> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        final int cutoff = 12;
        StringBuilder stringBuilder = new StringBuilder("TABLE: \n");
        for(String columnName : this.columnNames) {
            int stringLength = Math.min(columnName.length(), cutoff);
            stringBuilder.append(columnName, 0, stringLength).append("\t");
            if (stringLength < 12) {
                stringBuilder.append("\t");
            }
        }
        stringBuilder.append("\n");

        for(Integer columnType : this.columnSqlTypes) {
            stringBuilder.append(columnType).append("\t");
        }
        stringBuilder.append("\n");

        for(Set<Object> rows : this.rows) {
            for (Object row : rows) {
                int stringLength = Math.min(row.toString().length(), cutoff);
                stringBuilder.append(row.toString(), 0, stringLength).append("\t");

                if (stringLength < 12) {
                    stringBuilder.append("\t");
                }
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
