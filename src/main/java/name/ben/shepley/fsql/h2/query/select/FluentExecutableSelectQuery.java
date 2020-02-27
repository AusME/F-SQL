package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.ExecutableQuery;
import name.ben.shepley.fsql.framework.ExecutionContext;
import name.ben.shepley.fsql.framework.QueryStream;

public class FluentExecutableSelectQuery extends SelectQuery implements ExecutableQuery {
    private ExecutionContext executionContext;

    public FluentExecutableSelectQuery(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    @Override
    public QueryStream execute() {
        return executionContext.execute(this);
    }

}
