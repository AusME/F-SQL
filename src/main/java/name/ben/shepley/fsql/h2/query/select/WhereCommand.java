package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.SqlParameter;
import name.ben.shepley.fsql.h2.query.H2Select;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.Map;

public class WhereCommand extends NestedBuilder<H2Select> implements SqlParameter {
    private Map<String, Object> queryParameters;

    public WhereCommand(H2Select h2Select, Map<String, Object> queryParameters) {
        super(h2Select);
        this.queryParameters = queryParameters;
    }

    @Override
    public String toSql() {
        return null;
    }

    @Override
    public UnmodifiableMap getSqlParameters() {
        return null;
    }
}
