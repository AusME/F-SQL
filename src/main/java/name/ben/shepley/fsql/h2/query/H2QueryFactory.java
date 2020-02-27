package name.ben.shepley.fsql.h2.query;

import name.ben.shepley.fsql.framework.ExecutionContext;

public class H2QueryFactory {
    public static H2Select createSelectQuery() {
        return new H2Select(new ExecutionContext());
    }
}
