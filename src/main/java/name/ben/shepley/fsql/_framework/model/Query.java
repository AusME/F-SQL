package name.ben.shepley.fsql._framework.model;

import java.util.Map;

public interface Query {
    public abstract String toSql();
    public abstract Map<Integer, Object> getSqlParameters();
}
