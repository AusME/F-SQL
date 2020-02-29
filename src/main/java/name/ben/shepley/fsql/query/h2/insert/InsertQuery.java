package name.ben.shepley.fsql.query.h2.insert;

import name.ben.shepley.fsql.framework.model.Query;

import java.util.Collections;
import java.util.Map;

public class InsertQuery implements Query  {
    @Override
    public String toSql() {
        return "";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return Collections.emptyMap();
    }
}
