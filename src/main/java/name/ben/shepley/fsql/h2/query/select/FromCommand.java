package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.SqlParameter;
import name.ben.shepley.fsql.h2.query.H2Select;
import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.Map;

public class FromCommand extends NestedBuilder<H2Select> implements SqlParameter {
    /* Parent */
    private H2Select h2Select;

    /* FromCommand */
    private Map<String, Object> commandParameters;

    public FromCommand(H2Select h2Select, Map<String, Object> commandParameters) {
        super(h2Select);
        this.commandParameters = commandParameters;
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
