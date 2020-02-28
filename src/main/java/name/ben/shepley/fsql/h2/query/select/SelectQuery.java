package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.h2.query.select.command.FromCommand;
import name.ben.shepley.fsql.h2.query.select.command.SelectCommand;

import java.util.*;

public class SelectQuery implements Query {
    /* SQL COMPONENTS */
    protected SelectCommand selectCommand = new SelectCommand(this);
    protected FromCommand fromCommand = new FromCommand(this);

    /* OVERRIDDEN METHODS */
    @Override
    public String toSql() {
        return this.selectCommand.toSql() + fromCommand.toSql();
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