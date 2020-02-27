package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.SqlParameter;
import name.ben.shepley.fsql.h2.query.H2Select;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.*;

public class FromCommand extends NestedBuilder<H2Select> implements SqlParameter {
    private static final String FROM = "FROM";

    private Set<String> tablesOrViews = new HashSet<>();

    private Map<String, Object> queryParameters;

    public FromCommand(H2Select h2Select, Map<String, Object> queryParameters) {
        super(h2Select);
        this.queryParameters = queryParameters;
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
    public FromCommand from(String... tablesOrViews) {
        this.tablesOrViews.addAll(Arrays.asList(tablesOrViews));
        return this;
    }
}
