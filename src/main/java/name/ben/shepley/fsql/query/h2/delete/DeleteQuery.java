package name.ben.shepley.fsql.query.h2.delete;

import name.ben.shepley.fsql.framework.model.Query;

import java.util.Collections;
import java.util.Map;

public class DeleteQuery implements Query {
    @Override
    public String toSql() {
        return "";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return Collections.emptyMap();
    }
}