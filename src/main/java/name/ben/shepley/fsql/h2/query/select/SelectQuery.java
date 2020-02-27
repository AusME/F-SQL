package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.ExecutionContext;
import name.ben.shepley.fsql.framework.ExecutableQuery;
import name.ben.shepley.fsql.framework.QueryStream;
import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.h2.query.select.FromCommand;
import name.ben.shepley.fsql.h2.query.select.SelectCommand;

import java.util.*;

public class SelectQuery implements Query {
    /* SQL COMPONENTS */
    protected SelectCommand selectCommand = new SelectCommand(this);
    protected FromCommand fromCommand = new FromCommand(this);

    /* OVERRIDDEN METHODS */
    @Override
    public String toSql() {
        return null;
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return null;
    }

    /* COMMANDS: */
    public SelectCommand select() {
        return this.selectCommand;
    }

    public FromCommand from() {
        return this.fromCommand;
    }
}