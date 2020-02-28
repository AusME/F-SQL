package name.ben.shepley.fsql.h2.query.select.command;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.h2.query.select.SelectQuery;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.Map;

public class GroupByCommand extends NestedBuilder<SelectQuery> implements Query {
    public GroupByCommand(SelectQuery selectQuery) {
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
