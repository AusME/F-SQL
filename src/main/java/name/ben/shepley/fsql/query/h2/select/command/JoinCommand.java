package name.ben.shepley.fsql.query.h2.select.command;

import name.ben.shepley.fsql._framework.wrapper.NestedBuilder;
import name.ben.shepley.fsql._framework.model.Query;
import name.ben.shepley.fsql.query.h2.select.SelectQuery;

import java.util.Collections;
import java.util.Map;

public class JoinCommand extends NestedBuilder<SelectQuery> implements Query {
    public JoinCommand(SelectQuery selectQuery) {
        super(selectQuery);
    }

    @Override
    public String toSql() {
        return "";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return Collections.emptyMap();
    }
}

