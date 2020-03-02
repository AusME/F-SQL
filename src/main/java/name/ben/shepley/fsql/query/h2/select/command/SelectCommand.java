package name.ben.shepley.fsql.query.h2.select.command;

import name.ben.shepley.fsql.framework.model.NestedBuilder;
import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.query.h2.select.SelectQuery;

import java.util.*;

public class SelectCommand extends NestedBuilder<SelectQuery> implements Query {
    private static final String SELECT = "SELECT";

    private Set<String> columns = new HashSet<>();

    public SelectCommand(SelectQuery selectQuery) {
        super(selectQuery);
    }

    @Override
    public String toSql() {
        return SELECT + "\n\t" + String.join(",", columns);
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return  Collections.unmodifiableMap(new HashMap<>());
    }

    public SelectCommand addColumns(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public SelectCommand addColumns(Collection<String> columns) {
        this.columns.addAll(columns);
        return this;
    }
}
