package name.ben.shepley.fsql.h2.query;

import name.ben.shepley.fsql.framework.ExecutionContext;
import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.framework.QueryStream;
import name.ben.shepley.fsql.framework.SqlParameter;
import name.ben.shepley.fsql.h2.query.select.FromCommand;
import name.ben.shepley.fsql.h2.query.select.SelectCommand;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.*;

public class H2Select implements Query, SqlParameter {
    /* Query */
    private ExecutionContext executionContext;

    /* SqlCommand */
    protected Map<Integer, Object> parameters = new HashMap<>();

    /* SQL Data */
    protected SelectCommand selectCommand;
    protected FromCommand fromCommand;

    /* Can only be instantiated by factory */
    H2Select(ExecutionContext executionContext) {
        this.executionContext = executionContext;
        this.selectCommand = new SelectCommand();
        this.fromCommand = new FromCommand();
    }

    public SelectCommand select() {
        return this.selectCommand.getCommand();
    }

    public FromCommand from() {
        return this.fromCommand.getCommand();
    }

    @Override
    public QueryStream execute(Query query) {
        return null;
    }


    @Override
    public String toSql() {
        return null;
    }

    @Override
    public UnmodifiableMap getParameters() {
        return null;
    }
}