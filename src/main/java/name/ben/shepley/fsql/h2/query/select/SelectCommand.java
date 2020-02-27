package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.SqlParameter;
import name.ben.shepley.fsql.h2.query.H2Select;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.*;

public class SelectCommand extends NestedBuilder<H2Select> implements SqlParameter {
    private static final String SELECT = "SELECT";

    private Set<String> columns = new HashSet<>();

    private Map<String, Object> queryParameters;

    public SelectCommand(H2Select h2Select, Map<String, Object> queryParameters) {
        super(h2Select);
        this.queryParameters = queryParameters;
    }

    @Override
    public String toSql() {
        return SELECT + "\n\t" + String.join(",", columns) + "\n";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return  Collections.unmodifiableMap(new HashMap<>());
    }

    /* Meat Methods */
    public SelectCommand select(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public SelectCommand select(Collection<String> columns) {
        this.columns.addAll(columns);
        return this;
    }
}
