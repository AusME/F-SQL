package name.ben.shepley.fsql.query.sqlCommand;

import name.ben.shepley.fsql.query.Query;
import name.ben.shepley.fsql.query.QueryAware;

public class Select implements SqlCommand, QueryAware<Select> {
    /* Sql Command */
    private final static SqlCommandEnum COMMAND = SqlCommandEnum.SELECT;

    /* Parent Query */
    private Query<Select> query;

    /* SELECT Components */
    private String[] columns = new String[]{};
    private String table = "";

    /* Constructors */
    public Select(Query<Select> query) {
        this.query = query;
    }

    /* SqlCommand */
    @Override
    public SqlCommandEnum getCommand() {
        return COMMAND;
    }

    /* Parent Query */
    @Override
    public Query<Select> getQuery() {
        return this.query;
    }
    @Override
    public Select setQuery(Query<Select> query) {
        this.query = query;
        return this;
    }

    /* SELECT Components */
    public Select setColumns(String... columns) {
        if (columns != null) {
            this.columns = columns;
        }
        return this;
    }

    public Select setTable(String table) {
        if (table != null) {
            this.table = table;
        }
        return this;
    }

}
