package name.ben.shepley.fsql.framework.dataStructure;

public class Table {
    private String[] columnNames;
    private Class<?> columnTypes;
    private Object[][] rows;

    public String[] getColumnNames() {
        return columnNames;
    }
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public Class<?> getColumnTypes() {
        return columnTypes;
    }
    public void setColumnTypes(Class<?> columnTypes) {
        this.columnTypes = columnTypes;
    }

    public Object[][] getRows() {
        return rows;
    }
    public void setRows(Object[][] rows) {
        this.rows = rows;
    }
}
