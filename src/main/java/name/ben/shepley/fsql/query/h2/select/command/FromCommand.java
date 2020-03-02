package name.ben.shepley.fsql.query.h2.select.command;

import name.ben.shepley.fsql.framework.model.NestedBuilder;
import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.query.h2.select.SelectQuery;

import java.util.*;

public class FromCommand extends NestedBuilder<SelectQuery> implements Query {
    private static final String FROM = "FROM";

    private Set<String> tablesOrViews = new HashSet<>();

    public FromCommand(SelectQuery selectQuery) {
        super(selectQuery);
    }

    @Override
    public String toSql() {
        return FROM + "\n\t" + String.join(",", tablesOrViews) + "\n";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return  Collections.unmodifiableMap(new HashMap<>());
    }

    /* Meat Methods */
    public FromCommand addTables(String... tables) {
        this.tablesOrViews.addAll(Arrays.asList(tables));
        return this;
    }

}
