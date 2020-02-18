package name.ben.shepley.fsql.query;

import name.ben.shepley.fsql.ExecutionContext;
import name.ben.shepley.fsql.SqlDialect;

public class Query<T>  {
    private T command;
    private SqlDialect sqlDialect;
    private ExecutionContext executionContext;

    public T getCommand() {
        return command;
    }
    public Query<T> setCommand(T command) {
        this.command = command;
        return this;
    }

    public Query<T> setSqlDialect(SqlDialect sqlDialect) {
        this.sqlDialect = sqlDialect;
        return this;
    }

    public Query<T> setExecutionContext(ExecutionContext executionContext) {
        this.executionContext = executionContext;
        return this;
    }
}
