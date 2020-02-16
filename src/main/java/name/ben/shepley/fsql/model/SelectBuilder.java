package name.ben.shepley.fsql.model;

public class SelectBuilder {
    private String[] columns;
    private String table;

    public SelectBuilder select(String... columns) {
        this.columns = columns;
        return this;
    }

    public SelectBuilder from(String table) {
        this.table = table;
        return this;
    }

    public Select build() {
        return new Select(columns, table);
    }
}
