package name.ben.shepley.fsql.h2.query;

import name.ben.shepley.fsql.framework.ExecutionContext;
import name.ben.shepley.fsql.h2.query.select.FluentExecutableSelectQuery;
import name.ben.shepley.fsql.h2.query.select.SelectQuery;

public class H2QueryFactory {
    public static FluentExecutableSelectQuery createSelectQuery() {
        return new FluentExecutableSelectQuery(new ExecutionContext());
    }
}
