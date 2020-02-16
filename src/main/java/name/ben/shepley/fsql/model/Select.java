package name.ben.shepley.fsql.model;

import name.ben.shepley.fsql.SqlCommand;

public class Select implements SqlCommand {
    private final String[] columns;
    private final String table;

    public Select(String[] columns, String table) {
        this.columns = columns;
        this.table = table;
    }

    @Override
    public String toSql() {
        return "";
    }
}