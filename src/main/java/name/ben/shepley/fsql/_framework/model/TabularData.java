package name.ben.shepley.fsql._framework.model;

import java.util.*;

public class TabularData {
    private final Map<String, Class<?>> columns;
    private final List<List<Object>> rows;

    private TabularData(Map<String, Class<?>> columns, List<List<Object>> rows) {
        this.columns = Collections.unmodifiableMap(columns);
        this.rows = Collections.unmodifiableList(rows);
    }

    public Map<String, Class<?>> getColumns() {
        return columns;
    }
    public List<List<Object>> getRows() {
        return rows;
    }

    /* Operations TODO: SAFE and UNSAFE */
    public TabularData intersection(TabularData tabularData) {
        return tabularData;
    }

    public TabularData add(TabularData tabularData) {
        return tabularData;
    }

    public TabularData subtract(TabularData tabularData) {
        return tabularData;
    }

    public TabularData xor(TabularData tabularData) {
        return tabularData;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TabularData)) {
            return false;
        }

        TabularData queryResult = (TabularData) o;

        return true;
    }

    public static class TabularDataBuilder {
        private Map<String, Class<?>> columns = new LinkedHashMap<>();
        private List<List<Object>> rows = new LinkedList<>();

        public TabularData build() {
            return new TabularData(this.columns, this.rows);
        }

        public TabularDataBuilder addColumn(String name, Class<?> type) {
            columns.put(name, type);
            return this;
        }

        public TabularDataBuilder removeColumn(String name) {
            this.columns.remove(name);
            return this;
        }

        public TabularDataBuilder addRow(List<Object> row) {
            rows.add(row);
            return this;
        }

        public TabularDataBuilder removeRow(List<Object> row) {
            rows.remove(row);
            return this;
        }

        public TabularDataBuilder setColumns(Map<String, Class<?>> columns) {
            this.columns = columns;
            return this;
        }

        public TabularDataBuilder setRows(List<List<Object>> rows) {
            this.rows = rows;
            return this;
        }
    }
}
