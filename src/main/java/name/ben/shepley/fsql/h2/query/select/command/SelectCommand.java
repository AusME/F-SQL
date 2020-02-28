package name.ben.shepley.fsql.h2.query.select.command;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.h2.query.select.SelectQuery;

import java.util.*;

public class SelectCommand extends NestedBuilder<SelectQuery> implements Query {
    private static final String SELECT = "SELECT";

    private Set<String> columns = new HashSet<>();

    private Map<String, Object> queryParameters;

    public SelectCommand(SelectQuery selectQuery) {
        super(selectQuery);
    }

    @Override
    public String toSql() {
        return SELECT + "\n\t" + String.join(",", columns) + "\n";
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
