package name.ben.shepley.fsql.query.h2.select.command;

import name.ben.shepley.fsql.framework.model.NestedBuilder;
import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.query.h2.select.SelectQuery;

import java.util.Collections;
import java.util.Map;

public class HavingCommand extends NestedBuilder<SelectQuery> implements Query {
    public HavingCommand(SelectQuery selectQuery) {
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
