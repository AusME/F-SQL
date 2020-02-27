package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.Query;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.Map;

public class LimitCommand extends NestedBuilder<SelectQuery> implements Query {
    public LimitCommand(SelectQuery selectQuery) {
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
