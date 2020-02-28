package name.ben.shepley.fsql.h2.query.select.command;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.h2.query.select.SelectQuery;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.Map;

public class OrderCommand extends NestedBuilder<SelectQuery> implements Query {
    public OrderCommand(SelectQuery selectQuery) {
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
