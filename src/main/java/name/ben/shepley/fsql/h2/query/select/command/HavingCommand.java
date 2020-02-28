package name.ben.shepley.fsql.h2.query.select.command;

import name.ben.shepley.fsql.framework.dataStructure.NestedBuilder;
import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.h2.query.select.SelectQuery;

import java.util.Map;

public class HavingCommand extends NestedBuilder<SelectQuery> implements Query {
    public HavingCommand(SelectQuery selectQuery) {
        super(selectQuery);
    }

    @Override
    public String toSql() {
        return null;
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return null;
    }
}
