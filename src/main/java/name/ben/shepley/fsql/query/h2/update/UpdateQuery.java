package name.ben.shepley.fsql.query.h2.update;

import name.ben.shepley.fsql._framework.model.Query;

import java.util.Collections;
import java.util.Map;

public class UpdateQuery implements Query {
    @Override
    public String toSql() {
        return "";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return Collections.emptyMap();
    }
}